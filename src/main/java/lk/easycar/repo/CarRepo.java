package lk.easycar.repo;

import lk.easycar.dto.CarDTO;
import lk.easycar.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

/**
 * @author ishanka on 6/11/21 at 9:12 PM
 * @since 0.0.1
 */
public interface CarRepo extends JpaRepository<Car,String> {

    ArrayList<Car> findCarByCarTypeAndStatus(String type,String status);
    ArrayList<Car> findCarByBrandAndStatus(String brand,String status);
    ArrayList<Car> findCarByStatus(String status);
}
