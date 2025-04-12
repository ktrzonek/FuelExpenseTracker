package pl.coderslab.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.entity.TripExpense;
import pl.coderslab.repository.TripExpenseRepository;

@Service
@AllArgsConstructor
public class TripExpenseService {

    private final TripExpenseRepository tripExpenseRepository;

    public TripExpense addTripExpense(TripExpense tripExpense) {
        return tripExpenseRepository.save(tripExpense);
    }

    public void deleteTripExpense(Long id) {
        tripExpenseRepository.deleteById(id);
    }
}
