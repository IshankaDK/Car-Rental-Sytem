package lk.easycar.dto;

import lk.easycar.entity.Car;
import lk.easycar.entity.Customer;
import lk.easycar.entity.Driver;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ishanka on 6/13/21 at 12:24 AM
 * @since 0.0.1
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RentDTO {
    private String rentId;
    private String startDate;
    private String endDate;
    private int duration;
    private double monthRate;
    private double dayRate;
    private double cost;
    private int extraKM;
    private String status;
    private Customer customerEmail;
    private Car carId;
    private Driver driverId;
}
