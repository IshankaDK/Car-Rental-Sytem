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

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveFile(@RequestPart("nic") MultipartFile myFile) {

        System.out.println(myFile.getOriginalFilename());;

        try {
            // Let's get the project location
            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
            // Let's create a folder there for uploading purposes, if not exists
            File uploadsDir = new File(projectPath + "/customer");
            uploadsDir.mkdir();
            // It is time to transfer the file into the newly created dir
            myFile.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + myFile.getOriginalFilename()));
            System.out.println(projectPath);
            System.out.println(uploadsDir.getAbsolutePath());
            System.out.println(myFile.getOriginalFilename());
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
//{
//        "email":"idk@ada",
//        "address":"galle",
//        "nic":"2102151",
//        "driveLicense":"11111",
//        "contact":"113213",
//        "password":"10101010"
//        }