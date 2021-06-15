package lk.easycar.controller;

import lk.easycar.dto.RentDTO;
import lk.easycar.service.CustomerService;
import lk.easycar.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * @author ishanka on 6/14/21 at 10:27 PM
 * @since 0.0.1
 */
@CrossOrigin
@RestController
@RequestMapping("api/rentcar")
public class RentController {
    @Autowired
    private RentService service;


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveRent(@RequestBody RentDTO dto){
        System.out.println(dto.toString());
        boolean flag = service.AddRent(dto);
        System.out.println(flag +"Rent Save");
        return flag;
    }

    @GetMapping
    public ArrayList<RentDTO>  getAll(){
        ArrayList<RentDTO> allRents = service.getAllRents();
        for (RentDTO allRent : allRents) {
            System.out.println(allRent.toString());
        }
        return allRents;
    }
}
