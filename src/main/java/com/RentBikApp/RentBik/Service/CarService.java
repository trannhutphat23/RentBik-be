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

    public Object addCar(CarDto dto, Integer brandId, Integer typeId, Integer seriesId, Integer insuranceId){
        var car = toCar(dto);

        // check license plate
        if (carRepository.existsByLicensePlate(dto.licensePlate())){
            return new ErrorResponse("License plate must be unique");
        }

        Optional<Type> optionalType = typeRepository.findById(typeId);
        Optional<Brand> optionalBrand = brandRepository.findById(brandId);
        Optional<Series> optionalSeries = seriesRepository.findById(seriesId);
        if (insuranceId != null){
            Optional<Insurance> optionalInsurance = insuranceRepository.findById(insuranceId);
            if (optionalInsurance.isPresent()){
                Insurance insurance = optionalInsurance.get();
                car.setInsurance(insurance);
            }
        }

        if (optionalType.isPresent() && optionalBrand.isPresent() && optionalSeries.isPresent()){
            Type type = optionalType.get();
            Brand brand = optionalBrand.get();
            Series series = optionalSeries.get();

            car.setType(type);
            car.setBrand(brand);
            car.setSeries(series);
        }

        car.setHirePrice(dto.purchasePrice()*10/100);

        return carRepository.save(car);
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

    public List<CarResponseDto> searchCars(String keyword){
        List<Car> cars = carRepository.findByKeywordContainingIgnoreCase(keyword);

        return cars.stream()
                .map(this::toCarResponseDto)
                .collect(Collectors.toList());
    }

    public List<CarResponseDto> findCarNoInsurance(){
        List<Car> cars = carRepository.findCarHaveInsuranceNull();

        return cars.stream()
                .map(this::toCarResponseDto)
                .collect(Collectors.toList());
    }

    public Object addInsuranceForCar(Integer carId, Integer insuranceId){

        Optional<Car> optionalCar = carRepository.findById(carId);
        Optional<Insurance> optionalInsurance = insuranceRepository.findById(insuranceId);

        if (optionalCar.isEmpty() || optionalInsurance.isEmpty()){
            return new ErrorResponse("Car or insuracne not found");
        }

        carRepository.addNewInsurance(carId, insuranceId);

        return new SuccessResponse("Add insurance successfully");
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
                car.getCarNote(),
                car.getStatus()
        );
    }
}
