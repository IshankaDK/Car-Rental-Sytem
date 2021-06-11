package lk.easycar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ishanka on 6/11/21 at 9:11 PM
 * @since 0.0.1
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CarDTO {
    private String carId;
    private String brand;
    private int noOfPassengers;
    private String transmissionType;
    private String fuelType;
    private double dailyRate;
    private double monthlyRate;
    private String freeMileage;
    private double priceForExtraKM;
    private String registrationNumber;
    private String color;
    private String status;
}
