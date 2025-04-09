package pl.coderslab.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Car;
import pl.coderslab.entity.FuelExpense;
import pl.coderslab.service.CarService;
import pl.coderslab.service.FuelExpenseService;

@Controller
@AllArgsConstructor
@RequestMapping("/fuelExpense")
public class FuelExpenseController {
    private final FuelExpenseService fuelExpenseService;
    private final CarService carService;

    @GetMapping("/add")
    public String addFuelExpense(@RequestParam Long carId, Model model) {
        model.addAttribute("carId", carId);
        return "addFuelExpense";
    }

    @PostMapping("/add")
    public String addFuelExpense(@ModelAttribute FuelExpense fuelExpense, @RequestParam Long carId, Model model) {
        fuelExpenseService.addFuelExpense(fuelExpense);
        Car car = carService.getById(carId);
        car.getFuelExpenseList().add(fuelExpense);
        carService.updateCar(carId, car);
        return "redirect:/car/show/" + carId;
    }

    @GetMapping("/delete/{id}")
    public String deleteFuelExpense(@PathVariable Long id, @RequestParam Long carId) {
        fuelExpenseService.deleteFuelExpense(id);
        return "redirect:/car/show/" + carId;
    }



}
