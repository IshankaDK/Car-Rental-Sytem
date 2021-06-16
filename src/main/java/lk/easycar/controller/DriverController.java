package lk.easycar.controller;

import lk.easycar.dto.CustomerDTO;
import lk.easycar.dto.DriverDTO;
import lk.easycar.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * @author ishanka on 6/17/21 at 1:42 AM
 * @since 0.0.1
 */
@CrossOrigin
@RestController
@RequestMapping("api/driver")
public class DriverController {

    @Autowired
    private DriverService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveDriver(@RequestBody DriverDTO dto) {
        boolean b = service.AddDriver(dto);
        System.out.println(b+" driver saved");
        return b;
    }
    public void deleteDriver(@RequestParam String id) {
        boolean b = service.deleteDriver(id);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateDriver(@RequestBody DriverDTO dto) {
        boolean b = service.updateDriver(dto);
    }

    @GetMapping(params = {"id"} ,produces = MediaType.APPLICATION_JSON_VALUE)
    public DriverDTO searchDriver(@RequestParam String id) {
        DriverDTO driverDTO = service.searchDriver(id);
        return driverDTO;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<DriverDTO> getAllDrivers() {
        ArrayList<DriverDTO> list= service.getAllDriver();
        return list;
    }
}