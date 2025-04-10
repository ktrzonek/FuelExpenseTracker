package pl.coderslab.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dto.TripDTO;
import pl.coderslab.entity.*;
import pl.coderslab.service.CarService;
import pl.coderslab.service.TripService;

import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/trip")
public class TripController {
    private final TripService tripService;
    private final CarService carService;


//    @GetMapping("/{id}")
//    public ResponseEntity<Object> getTripById(@PathVariable Long id) {
//        Trip trip = tripService.getTripById(id);
//        if (trip == null) {
//            return ResponseEntity.notFound().build();
//        }
//
//        List<TripDTO> tripDTOList = new ArrayList<>();
//
//        double additionalCosts = trip.getTripExpenseList().stream()
//                .mapToDouble(TripExpenseController::getTripCost)
//                .sum();
//
//        TripDTO tripDTO = new TripDTO(
//                trip.getTripName(),
//                trip.getFuelConsumption(),
//                trip.getDistance(),
//                trip.getDate(),
//                additionalCosts
//        );
//        tripDTOList.add(tripDTO);
//        return ResponseEntity.ok(tripDTOList);
//    }



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
            return "errorPages/errorPageAddCar";
        }
    }

    @GetMapping("/delete/{tripId}")
    public String deleteTrip(@PathVariable Long tripId, @RequestParam Long carId) {
        tripService.deleteTrip(tripId);
        return "redirect:/car/show/" + carId;
    }

    @GetMapping("/show/{tripId}")
    public String showTrip(@PathVariable Long tripId, Model model) {
        Trip trip = tripService.getTripById(tripId);
        model.addAttribute("tripId", trip.getId());
        model.addAttribute("tripName", trip.getTripName());
        model.addAttribute("tripExpenses", trip.getTripExpenseList());
        return "listPages/TripExpenseList";
    }

}
