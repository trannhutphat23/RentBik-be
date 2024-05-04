package com.RentBikApp.RentBik.Service;

import com.RentBikApp.RentBik.DTO.InsuranceDto;
import com.RentBikApp.RentBik.Model.ErrorResponse;
import com.RentBikApp.RentBik.Model.Insurance;
import com.RentBikApp.RentBik.Repository.InsuranceRepository;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class InsuranceService {
    private final InsuranceRepository insuranceRepository;

    public InsuranceService(InsuranceRepository insuranceRepository) {
        this.insuranceRepository = insuranceRepository;
    }

    public Object addInsurance(InsuranceDto dto){
        var insurance = toInsurance(dto);

        // check mabh
        if (insuranceRepository.existsByMabh(insurance.getMabh())){
            return new ErrorResponse("Mabh must be unique");
        }

        return insuranceRepository.save(insurance);
    }

    public Insurance toInsurance(InsuranceDto dto){
        var insurance = new Insurance();
        insurance.setMabh(dto.mabh());
        insurance.setPurchaseDate(dto.purchaseDate());
        insurance.setExpiredDate(dto.expiredDate());
        insurance.setPurchasePrice(dto.purchasePrice());
        return insurance;
    }
}
