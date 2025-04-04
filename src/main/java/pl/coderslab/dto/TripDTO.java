package pl.coderslab.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class TripDTO {
    private String tripName;
    private Double fuelConsumption;
    private Double distance;
    private LocalDate date;
    private Double additionalCosts;

}
