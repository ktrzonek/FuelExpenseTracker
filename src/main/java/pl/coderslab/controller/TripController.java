package pl.coderslab.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.*;
import pl.coderslab.service.CarService;
import pl.coderslab.service.TripService;


@Controller
@AllArgsConstructor
@RequestMapping("/trip")
public class TripController {
    private final TripService tripService;
    private final CarService carService;


    @GetMapping("/add")
    public String addTrip(@RequestParam Long carId, Model model) {
        Car car = carService.getById(carId);
        model.addAttribute("carId", car.getId());
        model.addAttribute("make", car.getMake());
        model.addAttribute("model", car.getModel());
        return "addForms/addTrip";
    }

    @Transactional
    @PostMapping("/add")
    public String addTrip(@RequestParam Long carId, @ModelAttribute Trip trip) {
        try {
            Trip addedTrip = tripService.addTrip(trip);
            Car car = carService.getById(carId);
            car.getTripList().add(addedTrip);
            carService.updateCar(carId, car);
            return "redirect:/car/show/" + carId;
        } catch (IllegalArgumentException e) {
            return "errorPages/errorPage";
        }
    }

    @GetMapping("/delete/{tripId}")
    public String deleteTrip(@PathVariable Long tripId, @RequestParam Long carId) {
        tripService.deleteTrip(tripId);
        return "redirect:/car/show/" + carId;
    }

    @GetMapping("/show/{tripId}")
    public String showTrip(@PathVariable Long tripId, @RequestParam Long carId, Model model) {
        Trip trip = tripService.getTripById(tripId);
        model.addAttribute("tripId", trip.getId());
        model.addAttribute("tripName", trip.getTripName());
        model.addAttribute("tripExpenses", trip.getTripExpenseList());
        model.addAttribute("carId", carId);
        model.addAttribute("totalTripExpense", tripService.getTotalCostForTrip(tripId));
        return "listPages/TripExpenseList";
    }
}