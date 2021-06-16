package lk.easycar.controller;

import lk.easycar.dto.CustomerDTO;
import lk.easycar.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.ColumnResult;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

/**
 * @author ishanka on 6/11/21 at 8:16 PM
 * @since 0.0.1
 */
@CrossOrigin
@RestController
@RequestMapping("api/customer")
public class CustomerController {
    @Autowired
    private CustomerService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveCustomer(@RequestBody CustomerDTO dto) {
        boolean b = service.addCustomer(dto);
            System.out.println(b+" cus saved");
            return b;
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveNICAndLicenseFiles(@RequestPart("nic") MultipartFile myFile, @RequestPart("license") MultipartFile licenseFile) {
        try {
            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
            File uploadsDir = new File(projectPath + "/customer");
            uploadsDir.mkdir();
            myFile.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + myFile.getOriginalFilename()));
            licenseFile.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + licenseFile.getOriginalFilename()));
            System.out.println(myFile.getOriginalFilename());
            System.out.println(licenseFile.getOriginalFilename());
            return true;
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void deleteCustomer(@RequestParam String email) {
        boolean b = service.deleteCustomer(email);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateCustomer(@RequestBody CustomerDTO dto) {
        boolean b = service.updateCustomer(dto);
    }

    @GetMapping(params = {"email"} ,produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerDTO searchCustomer(@RequestParam String email) {
        CustomerDTO customerDTO = service.searchCustomer(email);
        System.out.println(customerDTO);
        return customerDTO;
    }

    public void getAllCustomers() {
        ArrayList<CustomerDTO> allCustomer = service.getAllCustomer();
    }
}
//{
//        "email":"idk@ada",
//        "address":"galle",
//        "nic":"2102151",
//        "driveLicense":"11111",
//        "contact":"113213",
//        "password":"10101010"
//        }