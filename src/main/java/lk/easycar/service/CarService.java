package lk.easycar.service;

import lk.easycar.dto.CarDTO;
import lk.easycar.dto.CustomerDTO;

import java.util.ArrayList;

/**
 * @author ishanka on 6/11/21 at 9:13 PM
 * @since 0.0.1
 */
public interface CarService {
    boolean addCar(CarDTO dto);
    boolean deleteCar(String carId);
    boolean updateCar(CarDTO dto);
    CarDTO searchCar(String carId);
    ArrayList<CarDTO> getAllCars();
    ArrayList<CarDTO> findCarByType(String type,String status);
    ArrayList<CarDTO> findCarByBrand(String brand,String status);
    ArrayList<CarDTO> findCarByStatus(String status);
}
