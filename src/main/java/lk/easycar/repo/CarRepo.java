package lk.easycar.repo;

import lk.easycar.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ishanka on 6/11/21 at 9:12 PM
 * @since 0.0.1
 */
public interface CarRepo extends JpaRepository<Car,String> {
}
