package lk.easycar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import java.io.Serializable;

/**
 * @author ishanka on 6/12/21 at 11:33 PM
 * @since 0.0.1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Car_RentDetail_PK implements Serializable {
    private String rentId;
    private String carId;
}
