package pl.coderslab.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Registration number must not be null")
    @Size(min = 4, max = 8, message = "Registration number must be between 4 and 8 characters")
    private String registrationNumber;

    @NotNull(message = "Make must not be null")
    private String make;

    @NotNull(message = "Model must not be null")
    private String model;

    @NotNull(message = "Fuel type must not be null")
    private String fuelType;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "car_id")
    private List<Trip> tripList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "car_id")
    private List<FuelExpense> fuelExpenseList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "car_id")
    private List<CarExpense> carExpenseList = new ArrayList<>();
}
