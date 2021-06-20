package lk.easycar.service.impl;

import lk.easycar.dto.CarDTO;
import lk.easycar.dto.RentDTO;
import lk.easycar.entity.Car;
import lk.easycar.entity.Rent;
import lk.easycar.repo.RentRepo;
import lk.easycar.service.RentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author ishanka on 6/14/21 at 8:07 PM
 * @since 0.0.1
 */

@Service
@Transactional
public class RentServiceImpl implements RentService {

    @Autowired
    private RentRepo rentRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public boolean AddRent(RentDTO dto) {
        rentRepo.save(mapper.map(dto, Rent.class));
        return true;
    }

    @Override
    public boolean deleteRent(Long id) {
        if (!rentRepo.existsById(id)) {
            return false;
        }
        rentRepo.deleteById(id);
        return true;
    }

    @Override
    public boolean updateRent(RentDTO dto) {
        if (!rentRepo.existsById(dto.getRentId())){
            return false;
        }
        rentRepo.save(mapper.map(dto, Rent.class));
        return true;
    }

    @Override
    public RentDTO searchRent(Long id) {
        Optional<Rent> rent = rentRepo.findById(id);
        if (rent.isPresent()){
            return mapper.map(rent.get(), RentDTO.class);
        }
        return null;
    }

    @Override
    public ArrayList<RentDTO> getAllRents() {
        List<Rent> all = rentRepo.findAll();
        return mapper.map(all, new TypeToken<ArrayList<RentDTO>>(){}.getType());
    }

    @Override
    public ArrayList<RentDTO> getRentsByStatus(String status) {
        ArrayList<Rent> rentByStatus = rentRepo.findRentByStatus(status);
        return mapper.map(rentByStatus,new TypeToken<ArrayList<RentDTO>>(){}.getType());
    }
}
