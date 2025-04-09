package pl.coderslab.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Car;
import pl.coderslab.entity.User;
import pl.coderslab.service.CarService;
import pl.coderslab.service.UserService;



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
            return "redirect:/user/cars/" + user.getId();
        } catch (IllegalArgumentException e) {
            return "errorPage";
        }
    }


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


    @GetMapping("/update/{carId}")
    public String showFormUpdateCar(@PathVariable Long carId, Model model, @RequestParam Long userId) {
        Car car = carService.getById(carId);
        model.addAttribute("carId", car.getId());
        model.addAttribute("make", car.getMake());
        model.addAttribute("model", car.getModel());
        model.addAttribute("registrationNumber", car.getRegistrationNumber());
        model.addAttribute("fuelType", car.getFuelType());
        model.addAttribute("userId", userId);
        return "updateCar";
    }

    @Transactional
    @PostMapping("/update/{carId}")
    public String updateCar(@PathVariable Long carId, @ModelAttribute Car car, @RequestParam Long userId) {
        Car updatedCar = carService.updateCar(carId, car);
        return "redirect:/user/cars/" + userId;
    }

    @GetMapping("/delete/{carId}")
    public String deleteUser(@PathVariable Long carId, @RequestParam Long userId) {
        carService.deleteCar(carId);
        return "redirect:/user/cars/" + userId;
    }

    @GetMapping("/show/{carId}")
    public String showCarInfo(@PathVariable Long carId, Model model) {
        Car car = carService.getById(carId);
        model.addAttribute("carId", car.getId());
        model.addAttribute("make", car.getMake());
        model.addAttribute("model", car.getModel());
        model.addAttribute("registrationNumber", car.getRegistrationNumber());
        model.addAttribute("fuelType", car.getFuelType());
        model.addAttribute("trips", car.getTripList());
        model.addAttribute("fuelExpenses", car.getFuelExpenseList());
        model.addAttribute("carExpenses", car.getCarExpenseList());
        model.addAttribute("totalFuelExpense", carService.getTotalFuelCostForCar(car.getId()));
        return "CarInfo";
    }





// zrobic na total trip cost z funkcji
}
