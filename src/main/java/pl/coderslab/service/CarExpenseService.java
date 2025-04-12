package pl.coderslab.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.entity.CarExpense;
import pl.coderslab.repository.CarExpenseRepository;


@Service
@AllArgsConstructor
public class CarExpenseService {

    private CarExpenseRepository carExpenseRepository;

    public CarExpense addCarExpense(CarExpense carExpense) {
        return carExpenseRepository.save(carExpense);
    }

    public void deleteCarExpense(Long id) {
        carExpenseRepository.deleteById(id);
    }
}
