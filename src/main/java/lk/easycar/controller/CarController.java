package lk.easycar.controller;

import com.mysql.cj.xdevapi.JsonParser;
import lk.easycar.dto.CarDTO;
import lk.easycar.service.CarService;
import lk.easycar.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ishanka on 6/11/21 at 8:16 PM
 * @since 0.0.1
 */
@CrossOrigin
@RestController
@RequestMapping("api/car")
public class CarController {
    @Autowired
    private CarService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveCar(@RequestBody CarDTO dto) {
        boolean flag = service.addCar(dto);
        System.out.println(flag + " car saved");
        return flag;
    }

    @DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean deleteCar(@RequestBody CarDTO dto) {
        System.out.println(dto.getCarId());
        boolean flag = service.deleteCar(dto.getCarId());
        System.out.println( " car deleted");
        return flag;
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean updateCar(@RequestBody CarDTO dto) {
        boolean flag = service.updateCar(dto);
        System.out.println(" car updated");
        return flag;
    }

    @GetMapping(params = {"id"})
    public CarDTO searchCar(@RequestParam String id) {
        CarDTO carDTO = service.searchCar(id);
        System.out.println(carDTO.toString());
        return carDTO;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<CarDTO> getAllCars() {
        ArrayList<CarDTO> allCars = service.getAllCars();
        for (CarDTO allCar : allCars) {
            System.out.println(allCar.toString());
        }
        return allCars;
    }
}
