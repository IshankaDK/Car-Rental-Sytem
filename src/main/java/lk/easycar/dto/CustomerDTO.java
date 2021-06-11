package lk.easycar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

/**
 * @author ishanka on 6/11/21 at 8:15 PM
 * @since 0.0.1
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerDTO {
    private String email;
    private String address;
    private String nic;
    private String driveLicense;
    private String contact;
    private String password;

}
