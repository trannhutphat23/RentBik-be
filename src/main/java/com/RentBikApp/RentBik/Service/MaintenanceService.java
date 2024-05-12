package com.RentBikApp.RentBik.Service;

import com.RentBikApp.RentBik.DTO.CarResponseDto;
import com.RentBikApp.RentBik.DTO.InsuranceDto;
import com.RentBikApp.RentBik.DTO.MaintenanceDto;
import com.RentBikApp.RentBik.DTO.MaintenanceResponseDto;
import com.RentBikApp.RentBik.Model.Car;
import com.RentBikApp.RentBik.Model.Insurance;
import com.RentBikApp.RentBik.Model.Maintenance;
import com.RentBikApp.RentBik.Repository.CarRepository;
import com.RentBikApp.RentBik.Repository.MaintenanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MaintenanceService {
    private final MaintenanceRepository maintenanceRepository;
    private final CarRepository carRepository;

    public MaintenanceService(MaintenanceRepository maintenanceRepository, CarRepository carRepository) {
        this.maintenanceRepository = maintenanceRepository;
        this.carRepository = carRepository;
    }

    public Object addMaintenance(MaintenanceDto dto, Integer carId){
        var maintenance = toMaintenance(dto);

        Optional<Car> optionalCar = carRepository.findById(carId);
        if (optionalCar.isPresent()) {
            Car car = optionalCar.get();
            maintenance.setCar(car);
        }

        return maintenanceRepository.save(maintenance);
    }

    public List<MaintenanceResponseDto> findAllMaintenance(){
        List<Maintenance> maintenances = maintenanceRepository.findAll();

        return maintenances.stream()
                .map(this::toMaintenanceResponseDto)
                .collect(Collectors.toList());
    }

    private Maintenance toMaintenance(MaintenanceDto dto){
        var maintenance = new Maintenance();
        maintenance.setMaintenanceDate(dto.maintenanceDate());
        maintenance.setMaintenanceNote(dto.maintenanceNote());
        return maintenance;
    }

    private MaintenanceResponseDto toMaintenanceResponseDto(Maintenance maintenance){
        return new MaintenanceResponseDto(
                maintenance.getId(),
                maintenance.getCar(),
                maintenance.getMaintenanceDate(),
                maintenance.getMaintenanceNote()
        );
    }
}
