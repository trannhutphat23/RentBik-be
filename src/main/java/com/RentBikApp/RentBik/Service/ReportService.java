package com.RentBikApp.RentBik.Service;

import com.RentBikApp.RentBik.DTO.ReportCarDto;
import com.RentBikApp.RentBik.DTO.ReportCustomerDto;
import com.RentBikApp.RentBik.Repository.CarRepository;
import com.RentBikApp.RentBik.Repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportService {
    private final CarRepository carRepository;
    private final CustomerRepository customerRepository;

    public ReportService(CarRepository carRepository, CustomerRepository customerRepository) {
        this.carRepository = carRepository;
        this.customerRepository = customerRepository;
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

    public List<ReportCustomerDto> getReportCustomer(){
        List<Object[]> reportCustomers = customerRepository.getReportCustomer();

        return reportCustomers.stream()
                .map(arr -> new ReportCustomerDto(
                        ((Number) arr[0]).intValue(),
                        (String) arr[1],
                        ((Number) arr[2]).intValue(),
                        ((Number) arr[3]).intValue(),
                        ((Number) arr[4]).intValue(),
                        ((Number) arr[5]).intValue(),
                        ((Number) arr[6]).floatValue()
                ))
                .collect(Collectors.toList());
    }
}
