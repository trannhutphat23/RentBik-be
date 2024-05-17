package com.RentBikApp.RentBik.Controller;

import com.RentBikApp.RentBik.DTO.RentDto;
import com.RentBikApp.RentBik.DTO.RentResponseDto;
import com.RentBikApp.RentBik.Model.Rent;
import com.RentBikApp.RentBik.Service.RentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class RentController {
    private final RentService rentService;

    public RentController(RentService rentService) {
        this.rentService = rentService;
    }

    @PostMapping("/rents/add")
    public Object addRent(
            @RequestBody RentDto dto
    ){
        return rentService.addRent(dto, dto.carId(), dto.customerId());
    }

    @GetMapping("/rents")
    public List<RentResponseDto> findAllRent(){
        return rentService.findAllRent();
    }
}
