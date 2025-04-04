package pl.coderslab.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Setter
@Getter
public class FuelExpense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Fuel cost must not be null")
    @Min(value = 0, message = "Fuel cost must be positive")
    private Double fuelCost;

    @NotNull(message = "Fuel amount must not be null")
    @Min(value = 0, message = "Fuel amount must be positive")
    private Double fuelAmount;

    private Double pricePerLiter;

    @NotNull(message = "Date must not be null")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
}
