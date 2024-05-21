package com.RentBikApp.RentBik.Service;

import com.RentBikApp.RentBik.DTO.ReportCarDto;
import com.RentBikApp.RentBik.Repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportService {
    private final CarRepository carRepository;

    public ReportService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<ReportCarDto> getReportCar(){
        List<Object[]> reportCars = carRepository.getReportCar();

        return reportCars.stream()
                .map(arr -> new ReportCarDto(
                        ((Number) arr[0]).intValue(),
                        (String) arr[1],
                        (String) arr[2],
                        (String) arr[3],
                        (String) arr[4],
                        ((Number) arr[5]).intValue(),
                        ((Number) arr[6]).intValue(),
                        ((Number) arr[7]).floatValue()
                ))
                .collect(Collectors.toList());
    }
}
