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

@Controller
@AllArgsConstructor
@RequestMapping("/car")
public class CarController {

    private final CarService carService;
    private final UserService userService;


    @GetMapping("/add")
    public String showFormAddCar(@RequestParam Long userId, Model model) {
        model.addAttribute("userId", userId);
        return "addCar";
    }

    @Transactional
    @PostMapping("/add")
    public String addCar(@ModelAttribute Car car, @RequestParam Long userId) {
        try {
            Car addedCar = carService.addCar(car);
            User user = userService.getUserById(userId);
            user.getCarList().add(addedCar);
            userService.updateUserCar(user);
//            return "redirect:/user/all";
            return "redirect:/user/cars/" + user.getId();
        } catch (IllegalArgumentException e) {
            return "errorPage";
        }
    }



    @Transactional
    @GetMapping("/{id}")
    public ResponseEntity<Car> getCar(@PathVariable Long id) {
        Car car = carService.getById(id);
        if (car == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(car);
    }
//    http://localhost:8080/car/1


    @Transactional
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
