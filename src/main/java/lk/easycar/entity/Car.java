package lk.easycar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author ishanka on 6/11/21 at 9:07 PM
 * @since 0.0.1
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Car {
    @Id
    private String carId;
    private String brand;
    private String carType;
    private int noOfPassengers;
    private String transmissionType;
    private String fuelType;
    private String color;
    private String registrationNumber;

    private double dailyRate;
    private int freeMileageForADay;
    private double monthlyRate;
    private int freeMileageForAMonth;
    private double priceForExtraKM;
    private double lossDamageWaiver;

    private String status;
}
