package pl.coderslab.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Trip;
import pl.coderslab.entity.TripExpense;
import pl.coderslab.service.TripExpenseService;
import pl.coderslab.service.TripService;

@Controller
@AllArgsConstructor
@RequestMapping("/tripExpense")
public class TripExpenseController {

    private final TripExpenseService tripExpenseService;
    private final TripService tripService;


    @GetMapping("/add")
    public String addTripExpense(@RequestParam Long tripId, @RequestParam Long carId, Model model) {
        Trip trip = tripService.getTripById(tripId);
        model.addAttribute("tripId", trip.getId());
        model.addAttribute("tripName", trip.getTripName());
        model.addAttribute("carId", carId);
        return "addForms/addTripExpense";
    }

    @PostMapping("/add")
    public String addTripExpense(@ModelAttribute TripExpense tripExpense, @RequestParam Long tripId, @RequestParam Long carId, Model model) {
        TripExpense newTripExpense = tripExpenseService.addTripExpense(tripExpense);
        Trip trip = tripService.getTripById(tripId);
        trip.getTripExpenseList().add(newTripExpense);
        tripService.updateTrip(tripId, trip);
        model.addAttribute("tripId", trip.getId());
        model.addAttribute("tripName", trip.getTripName());
        model.addAttribute("carId", carId);
        return "redirect:/trip/show/" + tripId + "?carId=" + carId;
    }

    @GetMapping("/delete/{id}")
    public String deleteTripExpense(@PathVariable Long id, @RequestParam Long tripId, @RequestParam Long carId) {
        tripExpenseService.deleteTripExpense(id);
        return "redirect:/trip/show/" + tripId + "?carId=" + carId;
    }
}
