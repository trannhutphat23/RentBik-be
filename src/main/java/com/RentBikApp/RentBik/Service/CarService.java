package com.RentBikApp.RentBik.Service;

import com.RentBikApp.RentBik.DTO.BrandDto;
import com.RentBikApp.RentBik.DTO.CarDto;
import com.RentBikApp.RentBik.Model.Brand;
import com.RentBikApp.RentBik.Model.Car;
import com.RentBikApp.RentBik.Repository.CarRepository;
import org.springframework.stereotype.Service;

@Service
public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car addCar(CarDto dto){
        var car = toCar(dto);



        return car;
    }

    private Car toCar(CarDto dto){
        var car = new Car();
        car.setLicensePlate(dto.licensePlate());
        car.setPurchasePrice(dto.purchasePrice());
        car.setPurchaseDate(dto.purchaseDate());
        car.setCarNote(dto.carNote());
        return car;
    }
}
