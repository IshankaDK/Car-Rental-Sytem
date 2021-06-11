package lk.easycar.controller;

import lk.easycar.dto.CarDTO;
import lk.easycar.service.CarService;
import lk.easycar.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;

/**
 * @author ishanka on 6/11/21 at 8:16 PM
 * @since 0.0.1
 */
@RestController
@RequestMapping("api/car")
public class AdminController {
    @Autowired
    private CarService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveCar(@RequestBody CarDTO dto) {
        boolean b = service.addCar(dto);
        System.out.println(b + " car saved");
    }

    @DeleteMapping(params = {"id"})
    public void deleteCar(@RequestParam String id) {
        boolean b = service.deleteCar(id);
        System.out.println(b + " car deleted");
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateCar(@RequestBody CarDTO dto) {
        boolean b = service.updateCar(dto);
        System.out.println(b + " car updated");
    }

    @GetMapping(params = {"id"})
    public void searchCar(@RequestParam String id) {
        CarDTO carDTO = service.searchCar(id);
        System.out.println(carDTO.toString());
    }

    @GetMapping
    public void getAllCars() {
        ArrayList<CarDTO> allCars = service.getAllCars();
        for (CarDTO allCar : allCars) {
            System.out.println(allCar.toString());
        }
    }
}
