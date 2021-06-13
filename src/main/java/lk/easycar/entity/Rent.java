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
    private String rentId;
    @ManyToOne
    @JoinColumn(name = "customerEmail",referencedColumnName = "email")
    private Customer customerEmail;
    @OneToMany(mappedBy = "rentId",cascade = CascadeType.ALL)
    private List<RentDetails> rentDetails = new ArrayList<>();

}
