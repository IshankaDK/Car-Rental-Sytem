package lk.easycar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ishanka on 6/12/21 at 8:30 PM
 * @since 0.0.1
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DriverDTO {
    private String driverId;
    private String driverName;
    private String driverAddress;
    private String driverContact;
    private String driverStatus;
}
