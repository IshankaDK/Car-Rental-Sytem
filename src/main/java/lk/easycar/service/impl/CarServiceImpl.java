package lk.easycar.service.impl;

import lk.easycar.dto.CarDTO;
import lk.easycar.dto.CustomerDTO;
import lk.easycar.entity.Car;
import lk.easycar.entity.Customer;
import lk.easycar.repo.CarRepo;
import lk.easycar.repo.CustomerRepo;
import lk.easycar.service.CarService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author ishanka on 6/11/21 at 9:13 PM
 * @since 0.0.1
 */
@Service
@Transactional
public class CarServiceImpl implements CarService {


    @Autowired
    private CarRepo carRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public boolean addCar(CarDTO dto) {
       carRepo.save(mapper.map(dto, Car.class));
       return true;
    }

    @Override
    public boolean deleteCar(String carId) {
        if (!carRepo.existsById(carId)) {
            return false;
        }
        carRepo.deleteById(carId);
        return true;
    }

    @Override
    public boolean updateCar(CarDTO dto) {
        if (!carRepo.existsById(dto.getCarId())){
            return false;
        }
        carRepo.save(mapper.map(dto, Car.class));
        return true;
    }

    @Override
    public CarDTO searchCar(String carId) {
        Optional<Car> car = carRepo.findById(carId);
        if (car.isPresent()){
            return mapper.map(car.get(), CarDTO.class);
        }
        return null;
    }

    @Override
    public ArrayList<CarDTO> getAllCars() {
        List<Car> all = carRepo.findAll();
        return mapper.map(all, new TypeToken<ArrayList<CarDTO>>(){}.getType());
    }

    @Override
    public ArrayList<CarDTO> findCarByType(String type) {
        ArrayList<Car> cars = carRepo.findCarByCarType(type);
        return mapper.map(cars,new TypeToken<ArrayList<CarDTO>>(){}.getType());
    }

    @Override
    public ArrayList<CarDTO> findCarByBrand(String brand) {
        ArrayList<Car> cars = carRepo.findCarByBrand(brand);
        return mapper.map(cars,new TypeToken<ArrayList<CarDTO>>(){}.getType());
    }

    @Override
    public ArrayList<CarDTO> findCarByStatus(String status) {
        ArrayList<Car> cars = carRepo.findCarByStatus(status);
        return mapper.map(cars,new TypeToken<ArrayList<CarDTO>>(){}.getType());
    }
}
