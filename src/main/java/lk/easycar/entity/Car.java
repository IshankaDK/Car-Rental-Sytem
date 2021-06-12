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
    private int noOfPassengers;
    private String transmissionType;
    private String fuelType;
    private double dailyRate;
    private double monthlyRate;
    private String freeMileage;
    private double priceForExtraKM;
    private String registrationNumber;
    private String color;
    private String type;
    private double lossDamageWaiver;
    private String status;


}
