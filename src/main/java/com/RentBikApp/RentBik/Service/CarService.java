package com.RentBikApp.RentBik.Service;

import com.RentBikApp.RentBik.DTO.CarDto;
import com.RentBikApp.RentBik.DTO.CarResponseDto;
import com.RentBikApp.RentBik.DTO.CustomerResponseDto;
import com.RentBikApp.RentBik.DTO.GplxResponseDto;
import com.RentBikApp.RentBik.Model.*;
import com.RentBikApp.RentBik.Repository.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CarService {
    private final CarRepository carRepository;
    private final TypeRepository typeRepository;
    private final BrandRepository brandRepository;
    private final SeriesRepository seriesRepository;
    private final InsuranceRepository insuranceRepository;

    public CarService(CarRepository carRepository, TypeRepository typeRepository, BrandRepository brandRepository, SeriesRepository seriesRepository, InsuranceRepository insuranceRepository) {
        this.carRepository = carRepository;
        this.typeRepository = typeRepository;
        this.brandRepository = brandRepository;
        this.seriesRepository = seriesRepository;
        this.insuranceRepository = insuranceRepository;
    }

    public Object addCar(CarDto dto){
        // check license plate
        if (carRepository.existsByLicensePlate(dto.licensePlate())){
            return new ErrorResponse("License plate must be unique");
        }

        Integer maxIdx = carRepository.findMaxIndex();
        if (maxIdx == null) {
            maxIdx = 0;
        }

        carRepository.saveCar(dto.brandId(), maxIdx, dto.insuranceId(), dto.purchaseDate(), dto.purchasePrice(), dto.seriesId(), dto.typeId(), dto.carNote(), dto.licensePlate());

        return new SuccessResponse("Add Successfully");
    }

    private Car toCar(CarDto dto){
        var car = new Car();
        car.setLicensePlate(dto.licensePlate());
        car.setPurchasePrice(dto.purchasePrice());
        car.setPurchaseDate(dto.purchaseDate());
        car.setCarNote(dto.carNote());
        return car;
    }

    public List<CarResponseDto> findAllCar(){
        List<Car> cars = carRepository.findAll();

        return cars.stream()
                .map(this::toCarResponseDto)
                .collect(Collectors.toList());
    }

    private CarResponseDto toCarResponseDto(Car car){
        return new CarResponseDto(
                car.getId(),
                car.getLicensePlate(),
                car.getType(),
                car.getBrand(),
                car.getSeries(),
                car.getInsurance(),
                car.getPurchasePrice(),
                car.getHirePrice(),
                car.getPurchaseDate(),
                car.getCarNote()
        );
    }
}
