package lk.easycar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author ishanka on 6/12/21 at 8:27 PM
 * @since 0.0.1
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Driver {
    @Id
    private String driverId;
    private String driverName;
    private String driverAddress;
    private String driverContact;
    private String driverStatus;
    private String driverEmail;
    private String driverPassword;
}
