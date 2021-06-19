package lk.easycar.controller;

import lk.easycar.dto.CarDTO;
import lk.easycar.dto.RentDTO;
import lk.easycar.service.CarService;
import lk.easycar.service.CustomerService;
import lk.easycar.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;

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
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveLossDamageWaiver(@RequestPart("receipt") MultipartFile myFile) {
        try {

            System.out.println(java.time.LocalDate.now());

            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
            File uploadsDir = new File(projectPath + "/rent/"+java.time.LocalDate.now());
            uploadsDir.mkdir();
            myFile.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + myFile.getOriginalFilename()));
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
    @GetMapping
    public ArrayList<RentDTO>  getAll(){
        ArrayList<RentDTO> allRents = service.getAllRents();
        for (RentDTO allRent : allRents) {
            System.out.println(allRent.toString());
        }
        return allRents;
    }


}
