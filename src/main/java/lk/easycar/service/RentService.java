package lk.easycar.service;

import lk.easycar.dto.RentDTO;

import java.util.ArrayList;

/**
 * @author ishanka on 6/14/21 at 7:44 PM
 * @since 0.0.1
 */
public interface RentService {
    boolean AddRent(RentDTO dto);
    boolean deleteRent(Long id);
    boolean updateRent(RentDTO dto);
    RentDTO searchRent(Long id);
    ArrayList<RentDTO> getAllRents();
    ArrayList<RentDTO> getRentsByStatus(String status);
}
