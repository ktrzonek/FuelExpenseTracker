package pl.coderslab.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Trip name must not be null")
    private String tripName;

    @NotNull(message = "Fuel consumption must not be null")
    private Double fuelConsumption;

    @NotNull(message = "Distance must not be null")
    private Double distance;

    @NotNull(message = "Date must not be null")
//    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;


    @OneToMany
    @JoinColumn(name = "trip_id")
    private List<TripExpense> tripExpenseList = new ArrayList<>();
}
