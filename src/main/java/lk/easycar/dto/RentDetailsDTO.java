package lk.easycar.dto;

import lk.easycar.entity.Car;
import lk.easycar.entity.Driver;
import lk.easycar.entity.Rent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author ishanka on 6/13/21 at 12:26 AM
 * @since 0.0.1
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RentDetailsDTO {
    private Car_RentDetail_PK_DTO car_rentDetail_pk;
    private String startDate;
    private String endDate;
    private int duration;
    private double cost;
    private String status;
    private Car carId;
    private Rent rentId;
    private Driver driverId;

}
