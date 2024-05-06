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
        return carService.addCar(dto, dto.brandId(), dto.typeId(), dto.seriesId(), dto.insuranceId());
    }

    @GetMapping("/cars")
    public List<CarResponseDto> findAllCar(){
        return carService.findAllCar();
    }

    @GetMapping("/cars/search")
    public List<CarResponseDto> searchCars(
            @RequestParam String keyword
    ){
        return carService.searchCars(keyword);
    }
}
