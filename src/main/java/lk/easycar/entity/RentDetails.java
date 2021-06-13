package lk.easycar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author ishanka on 6/12/21 at 9:47 PM
 * @since 0.0.1
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RentDetails {
    @EmbeddedId
    private Car_RentDetail_PK car_rentDetail_pk;
    private String startDate;
    private String endDate;
    private int duration;
    private double rate;
    private int extraKM;
    private double cost;
    private String status;
    @ManyToOne
    @JoinColumn(name = "carId",referencedColumnName = "carId",insertable = false,updatable = false)
    private Car carId;
    @ManyToOne
    @JoinColumn(name = "rentId",referencedColumnName = "rentId",insertable = false,updatable = false)
    private Rent rentId;
    @ManyToOne
    @JoinColumn(name = "driverId",referencedColumnName = "driverId",insertable = false,updatable = false)
    private Driver driverId;

}
