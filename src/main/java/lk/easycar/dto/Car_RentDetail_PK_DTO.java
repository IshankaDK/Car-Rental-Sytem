package lk.easycar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ishanka on 6/13/21 at 12:51 AM
 * @since 0.0.1
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Car_RentDetail_PK_DTO {
    private String rentId;
    private String carId;
}
