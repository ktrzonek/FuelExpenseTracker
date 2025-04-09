package pl.coderslab.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.entity.FuelExpense;
import pl.coderslab.repository.FuelExpenseRepository;

@Service
@AllArgsConstructor
public class FuelExpenseService {
    private final FuelExpenseRepository fuelExpenseRepository;

    public FuelExpense addFuelExpense(FuelExpense fuelExpense) {
        return fuelExpenseRepository.save(fuelExpense);
    }

    public void deleteFuelExpense(Long id){
        fuelExpenseRepository.deleteById(id);
    }

}
