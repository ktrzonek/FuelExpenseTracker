package pl.coderslab.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CarInfoDTO {
    private String registrationNumber;
    private String make;
    private String model;
    private Integer numberOfTrips;
    private Double totalFuelExpenses;
}
