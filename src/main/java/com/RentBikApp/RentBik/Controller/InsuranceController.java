package com.RentBikApp.RentBik.Controller;

import com.RentBikApp.RentBik.Model.Insurance;
import com.RentBikApp.RentBik.Service.InsuranceService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api/v1")
public class InsuranceController {
    private final InsuranceService insuranceService;

    public InsuranceController(InsuranceService insuranceService) {
        this.insuranceService = insuranceService;
    }

    @PostMapping("/addInsurance")
    public Insurance addInsurance(
            @RequestBody Insurance insurance
    ){
        return insuranceService.addInsurance(insurance);
    }
}
