package com.RentBikApp.RentBik.Controller;

import com.RentBikApp.RentBik.DTO.HireInfoDto;
import com.RentBikApp.RentBik.DTO.HireInfoResponseDto;
import com.RentBikApp.RentBik.Service.ReturnCardService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class ReturnCardController {
    private final ReturnCardService returnCardService;

    public ReturnCardController(ReturnCardService returnCardService) {
        this.returnCardService = returnCardService;
    }

    @GetMapping("/return_cards/hire_info_price")
    public Object getHireInfoPrice(
            @RequestBody HireInfoDto dto
    ){
        return returnCardService.getHireInfoPrice(dto.customerId(), dto.carId(), dto.returnDate());
    }
}
