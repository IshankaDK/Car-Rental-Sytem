package lk.easycar.repo;

import lk.easycar.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

/**
 * @author ishanka on 6/17/21 at 1:32 AM
 * @since 0.0.1
 */
public interface DriverRepo extends JpaRepository<Driver,String> {
    ArrayList<Driver> findDriverByDriverStatus(String status);
}
