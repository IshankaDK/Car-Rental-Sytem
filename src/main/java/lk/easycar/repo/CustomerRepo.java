package lk.easycar.repo;

import lk.easycar.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ishanka on 6/11/21 at 8:15 PM
 * @since 0.0.1
 */
public interface CustomerRepo extends JpaRepository<Customer,String> {
}
