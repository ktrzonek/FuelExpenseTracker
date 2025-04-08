package pl.coderslab.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.entity.Car;
import pl.coderslab.entity.Trip;
import pl.coderslab.entity.TripExpense;
import pl.coderslab.repository.TripRepository;

import java.util.List;


@Service
@AllArgsConstructor
public class TripService {

    private final TripRepository tripRepository;

    public Double getTotalCostForTrip(Long id) {
        Trip trip = tripRepository.getTripById(id);
        if  (trip != null && trip.getTripExpenseList() != null) {
            return trip.getTripExpenseList().stream()
                    .mapToDouble(TripExpense::getTripCost)
                    .sum();
        }
        return 0.0;
    }


    public Trip getTripById(Long id) {
        return tripRepository.getTripById(id);
    }

    //dodane
//    public List<Trip> getAllTrips(Long carId) {
//        return tripRepository.getTripsByCarId(carId);
//    }

}
