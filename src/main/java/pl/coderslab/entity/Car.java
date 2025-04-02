package pl.coderslab.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
    @NotNull
    private String registrationNumber;
    @NotNull
    private String make;
    @NotNull
    private String model;
    @NotNull
    private String fuelType;

    @OneToMany
    @JoinColumn(name = "car_id")
    private List<Trip> tripList = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "car_id")
    private List<FuelExpense> fuelExpenseList = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "car_id")
    private List<CarExpense> carExpenseList = new ArrayList<>();
}
