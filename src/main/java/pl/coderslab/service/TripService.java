package pl.coderslab.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.entity.Trip;
import pl.coderslab.entity.TripExpense;
import pl.coderslab.repository.TripRepository;


@Service
@AllArgsConstructor
public class TripService {

    private final TripRepository tripRepository;

    public Double getTotalCostForTrip(Long id) {
        Trip trip = tripRepository.getTripById(id);
        if (trip != null && trip.getTripExpenseList() != null) {
            return trip.getTripExpenseList().stream()
                    .mapToDouble(TripExpense::getTripCost)
                    .sum();
        }
        return 0.0;
    }

    public Trip getTripById(Long id) {
        return tripRepository.getTripById(id);
    }

    public Trip addTrip(Trip trip) {
        return tripRepository.save(trip);
    }

    public Trip updateTrip(Long tripId, Trip trip) {
        Trip tripToUpdate = tripRepository.getTripById(tripId);
        tripToUpdate.setTripName(trip.getTripName());
        tripToUpdate.setDate(trip.getDate());
        tripToUpdate.setDistance(trip.getDistance());
        tripToUpdate.setFuelConsumption(trip.getFuelConsumption());
        tripToUpdate.setTripExpenseList(trip.getTripExpenseList());
        return tripRepository.save(tripToUpdate);
    }

    public void deleteTrip(Long id) {
        tripRepository.deleteById(id);
    }
}
