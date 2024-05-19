package com.RentBikApp.RentBik.Service;

import com.RentBikApp.RentBik.DTO.HireInfoResponseDto;
import com.RentBikApp.RentBik.Model.Car;
import com.RentBikApp.RentBik.Model.ErrorResponse;
import com.RentBikApp.RentBik.Repository.CarRepository;
import com.RentBikApp.RentBik.Repository.RentRepository;
import com.RentBikApp.RentBik.Repository.ReturnCardRepository;
import org.springframework.stereotype.Service;
import java.time.temporal.ChronoUnit;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ReturnCardService {
    private final ReturnCardRepository returnCardRepository;
    private final RentRepository rentRepository;
    private final CarRepository carRepository;
    public ReturnCardService(ReturnCardRepository returnCardRepository, RentRepository rentRepository, CarRepository carRepository) {
        this.returnCardRepository = returnCardRepository;
        this.rentRepository = rentRepository;
        this.carRepository = carRepository;
    }

    public Object getHireInfoPrice(Integer customerId, Integer carId, LocalDate returnDate){
        LocalDate expiryDate = rentRepository.getExpiryDate(customerId, carId);
        Optional<Car> optionalCar = carRepository.findById(carId);
        if (optionalCar.isPresent()){
            Car car = optionalCar.get();
            long daysBetween = ChronoUnit.DAYS.between(expiryDate, returnDate);

            if (daysBetween > 0){
                // finePrice = 2%.hirePrice*days
                float finePrice = daysBetween*(car.getHirePrice()*2/100);
                float sumPrice = finePrice + car.getHirePrice();

                return new HireInfoResponseDto(finePrice, sumPrice);
            }else{
                float finePrice = 0;
                float sumPrice = car.getHirePrice();

                return new HireInfoResponseDto(finePrice, sumPrice);
            }
        }else {
            return new ErrorResponse("No exist customer or car");
        }
    }
}
