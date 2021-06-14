package lk.easycar.service;

import lk.easycar.dto.RentDTO;

import java.util.ArrayList;

/**
 * @author ishanka on 6/14/21 at 7:44 PM
 * @since 0.0.1
 */
public interface RentService {
    void AddRent(RentDTO dto);
    void deleteRent(String id);
    void updateRent(RentDTO dto);
    RentDTO searchRent(String id);
    ArrayList<RentDTO> getAllRents();
}
