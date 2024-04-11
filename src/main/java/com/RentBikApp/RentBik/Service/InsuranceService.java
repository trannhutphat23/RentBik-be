package com.RentBikApp.RentBik.Service;

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

    public Insurance addInsurance(Insurance insurance){
        return insuranceRepository.save(insurance);
    }
}
