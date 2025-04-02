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
    @NotNull
    private String tripName;
    @NotNull
    private Double fuelConsumption;
    @NotNull
    private Double distance;
    @NotNull
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;

    @OneToMany
    @JoinColumn(name = "trip_id")
    private List<TripExpense> tripExpenseList = new ArrayList<>();
}
