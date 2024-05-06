package com.RentBikApp.RentBik.Controller;

import com.RentBikApp.RentBik.DTO.CarDto;
import com.RentBikApp.RentBik.DTO.CarResponseDto;
import com.RentBikApp.RentBik.Model.Car;
import com.RentBikApp.RentBik.Service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping("/cars/add")
    public Object addCar(
            @RequestBody CarDto dto
    ){
        return carService.addCar(dto);
    }

    @GetMapping("/cars")
    public List<CarResponseDto> findAllCar(){
        return carService.findAllCar();
    }
}
