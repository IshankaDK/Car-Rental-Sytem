package lk.easycar.service.impl;

import lk.easycar.dto.CustomerDTO;
import lk.easycar.dto.DriverDTO;
import lk.easycar.dto.RentDTO;
import lk.easycar.entity.Car;
import lk.easycar.entity.Customer;
import lk.easycar.entity.Driver;
import lk.easycar.repo.DriverRepo;
import lk.easycar.service.DriverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author ishanka on 6/17/21 at 1:36 AM
 * @since 0.0.1
 */
@Service
@Transactional
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepo driverRepo;

    @Autowired
    private ModelMapper mapper;
    @Override
    public boolean AddDriver(DriverDTO dto) {
        driverRepo.save(mapper.map(dto, Driver.class));
        return true;
    }

    @Override
    public boolean deleteDriver(String id) {
        if (!driverRepo.existsById(id)) {
            return false;
        }
        driverRepo.deleteById(id);
        return true;
    }

    @Override
    public boolean updateDriver(DriverDTO dto) {
        if (!driverRepo.existsById(dto.getDriverId())) {
//            throw new ValidateException("Customer Not Exist");
            return false;
        }
        driverRepo.save(mapper.map(dto, Driver.class));
        return true;
    }

    @Override
    public DriverDTO searchDriver(String id) {
        if (!driverRepo.existsById(id)) {
//            throw new ValidateException("Customer Not Exist");
            return null;
        }
        Optional<Driver> driver = driverRepo.findById(id);
        if (driver.isPresent()){
            return mapper.map(driver.get(), DriverDTO.class);
        }
        return null;
    }

    @Override
    public ArrayList<DriverDTO> getAllDriver() {
        List<Driver> all = driverRepo.findAll();
        return mapper.map(all,new TypeToken<ArrayList<DriverDTO>>(){}.getType());
    }

    @Override
    public ArrayList<DriverDTO> findByStatus(String status) {
        ArrayList<Driver> driverByDriverStatus = driverRepo.findDriverByDriverStatus(status);
        return mapper.map(driverByDriverStatus,new TypeToken<ArrayList<DriverDTO>>(){}.getType());
    }
}
