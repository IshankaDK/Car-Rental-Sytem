package lk.easycar.service;

import lk.easycar.dto.CustomerDTO;

import java.util.ArrayList;

/**
 * @author ishanka on 6/11/21 at 8:17 PM
 * @since 0.0.1
 */
public interface CustomerService {
    boolean addCustomer(CustomerDTO dto);
    boolean deleteCustomer(String email);
    boolean updateCustomer(CustomerDTO dto);
    CustomerDTO searchCustomer(String email);
    ArrayList<CustomerDTO> getAllCustomer();
    Long getNoOfCustomers();
}
