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
public class CarExpense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Expense name must not be null")
    private String expenseName;

    @NotNull(message = "Value must not be null")
    @Min(value = 0, message = "Value must be positive")
    private Double carCost;

    @NotNull(message = "Date must not be null")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
}
