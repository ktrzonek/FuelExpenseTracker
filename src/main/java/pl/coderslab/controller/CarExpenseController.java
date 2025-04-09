package pl.coderslab.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Car;
import pl.coderslab.entity.CarExpense;
import pl.coderslab.service.CarExpenseService;
import pl.coderslab.service.CarService;

@Controller
@AllArgsConstructor
@RequestMapping("/carExpense")
public class CarExpenseController {
    private final CarExpenseService carExpenseService;
    private final CarService carService;

    @GetMapping("/add")
    public String addCarExpense(@RequestParam Long carId, Model model) {
        Car car = carService.getById(carId);
        model.addAttribute("carId", car.getId());
        model.addAttribute("make", car.getMake());
        model.addAttribute("model", car.getModel());
        return "addCarExpense";
    }

    @PostMapping("/add")
    public String addCarExpense(@RequestParam Long carId, @ModelAttribute CarExpense carExpense, Model model) {
        CarExpense newCarExpense = carExpenseService.addCarExpense(carExpense);
        Car car = carService.getById(carId);
        car.getCarExpenseList().add(newCarExpense);
        carService.updateCar(carId, car);
        return "redirect:/car/show/" + carId;
    }

    @GetMapping("/delete/{id}")
    public String deleteCarExpense(@PathVariable Long id, @RequestParam Long carId) {
        carExpenseService.deleteCarExpense(id);
        return "redirect:/car/show/" + carId;
    }
}
