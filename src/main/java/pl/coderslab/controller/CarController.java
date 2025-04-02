package pl.coderslab.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.entity.Car;
import pl.coderslab.service.CarService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/car")
public class CarController {

    private final CarService carService;

    @GetMapping("/all")
    public ResponseEntity<List<Car>> getAllCars() {
        List<Car> cars = carService.getAll();
        if (cars.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cars);
    }
//    http://localhost:8080/car/all

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCar(@PathVariable Long id) {
        Car car = carService.getById(id);
        if (car == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(car);
    }
//    http://localhost:8080/car/1

    @GetMapping("/{id}/total-fuel-cost")
    public ResponseEntity<Double> getTotalFuelCost(@PathVariable Long id) {
        Double totalFuelCost = carService.getTotalFuelCostForCar(id);
        if (totalFuelCost == 0.0) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(totalFuelCost);
    }
//    http://localhost:8080/car/1/total-fuel-cost

}
