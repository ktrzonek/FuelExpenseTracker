package pl.coderslab.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.dto.TripDTO;
import pl.coderslab.entity.*;
import pl.coderslab.service.TripService;

import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/trip")
public class TripController {
    private final TripService tripService;


    @GetMapping("/{id}")
    public ResponseEntity<Object> getTripById(@PathVariable Long id) {
        Trip trip = tripService.getTripById(id);
        if (trip == null) {
            return ResponseEntity.notFound().build();
        }

        List<TripDTO> tripDTOList = new ArrayList<>();

        double additionalCosts = trip.getTripExpenseList().stream()
                .mapToDouble(TripExpense::getTripCost)
                .sum();

        TripDTO tripDTO = new TripDTO(
                trip.getTripName(),
                trip.getFuelConsumption(),
                trip.getDistance(),
                trip.getDate(),
                additionalCosts
        );
        tripDTOList.add(tripDTO);
        return ResponseEntity.ok(tripDTOList);
    }


}
