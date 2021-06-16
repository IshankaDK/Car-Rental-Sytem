package lk.easycar.service;

import lk.easycar.dto.DriverDTO;
import lk.easycar.dto.RentDTO;

import java.util.ArrayList;

/**
 * @author ishanka on 6/17/21 at 1:34 AM
 * @since 0.0.1
 */
public interface DriverService {
    boolean AddDriver(DriverDTO dto);
    boolean deleteDriver(String id);
    boolean updateDriver(DriverDTO dto);
    DriverDTO searchDriver(String id);
    ArrayList<DriverDTO> getAllDriver();
    ArrayList<DriverDTO> findByStatus(String status);
}
