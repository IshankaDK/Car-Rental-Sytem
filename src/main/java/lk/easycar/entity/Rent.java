package lk.easycar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ishanka on 6/12/21 at 8:31 PM
 * @since 0.0.1
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Rent {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long rentId;
    private String startDate;
    private String endDate;
    private int duration;
    private double monthRate;
    private double dayRate;
    private double cost;
    private int extraKM;
    private String status;
    @ManyToOne
    @JoinColumn(name = "customerEmail",referencedColumnName = "email")
    private Customer customerEmail;
    @ManyToOne
    @JoinColumn(name = "carId",referencedColumnName = "carId")
    private Car carId;
    @ManyToOne
    @JoinColumn(name = "driverId",referencedColumnName = "driverId")
    private Driver driverId;
}
