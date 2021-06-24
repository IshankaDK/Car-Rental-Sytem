package lk.easycar.controller;

import lk.easycar.dto.RentDTO;
import lk.easycar.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDate;
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
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean updateRent(@RequestBody RentDTO dto){
        System.out.println(dto.toString());
        boolean flag = service.updateRent(dto);
        System.out.println(flag +"Rent updated");
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

    @GetMapping(params = {"status"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<RentDTO> getPendingRequests(String status){
        ArrayList<RentDTO> rentsByStatus = service.getRentsByStatus(status);
        for (RentDTO rentDTO : rentsByStatus) {
            System.out.println(rentDTO.toString());
        }
        return rentsByStatus;
    }


    @GetMapping(params = {"email"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<RentDTO> getRentRequestsForCustomer(String email){
        ArrayList<RentDTO> rentsByEmail = service.getRentsByEmail(email);
        for (RentDTO rentDTO : rentsByEmail) {
            System.out.println(rentDTO.toString());
        }
        return rentsByEmail;
    }
    @GetMapping(params = {"id","status"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<RentDTO> getDriverSchedule(String id,String status){
        ArrayList<RentDTO> diverSchedule = service.getRentsByDriverAndStatus(id,status);
        return diverSchedule;
    }

    @GetMapping(params = {"start","status"})
    public Long getTodayBookings(String start,String status){
        return service.getTodayBooking(LocalDate.now().toString(),status);
    }
}
