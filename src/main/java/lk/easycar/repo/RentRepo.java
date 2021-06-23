package lk.easycar.repo;

import lk.easycar.entity.Customer;
import lk.easycar.entity.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

/**
 * @author ishanka on 6/14/21 at 8:09 PM
 * @since 0.0.1
 */
public interface RentRepo extends JpaRepository<Rent,Long> {

    ArrayList<Rent> findRentByStatus(String status);
    ArrayList<Rent> findRentByCustomerEmail_Email(String email);
    ArrayList<Rent> findRentByDriverId_DriverIdAndStatus(String id,String status);
}
