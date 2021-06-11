package lk.easycar.controller;

import lk.easycar.dto.CustomerDTO;
import lk.easycar.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @author ishanka on 6/11/21 at 8:16 PM
 * @since 0.0.1
 */
@RestController
@RequestMapping("api/customer")
public class CustomerController {
    @Autowired
    private CustomerService service;

    public void saveCustomer(@RequestBody CustomerDTO dto) {
        boolean b = service.addCustomer(dto);
    }

    public void deleteCustomer(@RequestParam String email) {
        boolean b = service.deleteCustomer(email);
    }

    public void updateCustomer(@RequestBody CustomerDTO dto) {
        boolean b = service.updateCustomer(dto);
    }

    public void searchCustomer(@RequestParam String email) {
        CustomerDTO customerDTO = service.searchCustomer(email);
    }

    public void getAllCustomers() {
        ArrayList<CustomerDTO> allCustomer = service.getAllCustomer();
    }
}
