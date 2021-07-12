package lk.easycar.service.impl;

import lk.easycar.dto.CustomerDTO;
import lk.easycar.entity.Customer;
import lk.easycar.repo.CustomerRepo;
import lk.easycar.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author ishanka on 6/11/21 at 8:18 PM
 * @since 0.0.1
 */
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public boolean addCustomer(CustomerDTO dto) {
        if (customerRepo.existsById(dto.getEmail())) {
//            throw new ValidateException("Customer Already Exist");
            return false;
        }
        customerRepo.save(mapper.map(dto, Customer.class));
        return true;
    }

    @Override
    public boolean deleteCustomer(String email) {
        if (!customerRepo.existsById(email)) {
            return false;
        }
        customerRepo.deleteById(email);
        return true;
    }

    @Override
    public boolean updateCustomer(CustomerDTO dto) {
        if (!customerRepo.existsById(dto.getEmail())) {
//            throw new ValidateException("Customer Not Exist");
            return false;
        }

        customerRepo.save(mapper.map(dto, Customer.class));
        return true;
    }

    @Override
    public CustomerDTO searchCustomer(String email) {
        if (!customerRepo.existsById(email)) {
//            throw new ValidateException("Customer Not Exist");
            return null;
        }
        Optional<Customer> customer = customerRepo.findById(email);
        if (customer.isPresent()){
            return mapper.map(customer.get(),CustomerDTO.class);
        }
        return null;
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomer() {
        List<Customer> all = customerRepo.findAll();
        return mapper.map(all,new TypeToken<ArrayList<CustomerDTO>>(){}.getType());
    }

    @Override
    public Long getNoOfCustomers() {
       return customerRepo.countCustomersBy();
//        return 0;
    }
}
