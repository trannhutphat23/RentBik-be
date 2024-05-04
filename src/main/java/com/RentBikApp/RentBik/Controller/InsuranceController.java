package com.RentBikApp.RentBik.Controller;

import com.RentBikApp.RentBik.DTO.InsuranceDto;
import com.RentBikApp.RentBik.Model.Insurance;
import com.RentBikApp.RentBik.Service.InsuranceService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class InsuranceController {
    private final InsuranceService insuranceService;

    public InsuranceController(InsuranceService insuranceService) {
        this.insuranceService = insuranceService;
    }

    @PostMapping("/insurances/add")
    public Object addInsurance(
            @RequestBody InsuranceDto dto
    ){
        return insuranceService.addInsurance(dto);
    }
}
