package lk.easycar.repo;

import lk.easycar.entity.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ishanka on 6/14/21 at 8:09 PM
 * @since 0.0.1
 */
public interface RentRepo extends JpaRepository<Rent,Long> {
}
