package lk.easycar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ishanka on 6/13/21 at 12:24 AM
 * @since 0.0.1
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RentDTO {
    private String rentId;
    private CustomerDTO customerId;
    private List<RentDetailsDTO> rentDetails = new ArrayList<>();
}
