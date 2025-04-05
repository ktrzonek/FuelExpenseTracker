package pl.coderslab.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dto.CarInfoDTO;
import pl.coderslab.entity.Car;
import pl.coderslab.entity.FuelExpense;
import pl.coderslab.entity.User;
import pl.coderslab.service.CarService;
import pl.coderslab.service.UserService;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/car")
public class CarController {

    private final CarService carService;
    private final UserService userService;

    @PostMapping("/add")
    public ResponseEntity<Car> addCar(@ModelAttribute Car car) {
        Car addedCar = carService.addCar(car);
        if (addedCar == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(addedCar);
    }


    @Transactional
    @PostMapping("/addCarToNewUser")
    public  String addCarToNewUser(@ModelAttribute Car car, @RequestParam Long userId, Model model) {
        Car addedCar = carService.addCar(car);
        User user = userService.getUserById(userId);

        model.addAttribute("email", user.getEmail());
        model.addAttribute("cars", user.getCarList());

        user.getCarList().add(addedCar);
        userService.updateUserCar(user);
//        return "redirect:/user/{userId}/cars";
        return "addUserjsp";
    }


    @GetMapping("/all")
    public ResponseEntity<List<Car>> getAllCars() {
        List<Car> cars = carService.getAll();
        if (cars.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cars);
    }
//    http://localhost:8080/car/all

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCar(@PathVariable Long id) {
        Car car = carService.getById(id);
        if (car == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(car);
    }
//    http://localhost:8080/car/1


    @GetMapping("/{id}/total-fuel-cost")
    public ResponseEntity<Double> getTotalFuelCost(@PathVariable Long id) {
        Double totalFuelCost = carService.getTotalFuelCostForCar(id);
        if (totalFuelCost == 0.0) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(totalFuelCost);
    }
//    http://localhost:8080/car/1/total-fuel-cost



// zrobic na total trip cost z funkcji
}
