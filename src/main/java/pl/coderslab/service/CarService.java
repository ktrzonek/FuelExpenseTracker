package pl.coderslab.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.entity.Car;
import pl.coderslab.entity.FuelExpense;
import pl.coderslab.repository.CarRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    public List<Car> getAll() {
        return carRepository.findAll();
    }

    public Car getById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    public Double getTotalFuelCostForCar(Long id) {
        Car car = carRepository.findById(id).orElse(null);
        if (car != null && car.getFuelExpenseList() != null) {
            return car.getFuelExpenseList().stream()
                    .mapToDouble(FuelExpense::getFuelCost)
                    .sum();
        }
        return 0.0;
    }



}
