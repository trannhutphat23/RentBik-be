package com.RentBikApp.RentBik.Controller;

import com.RentBikApp.RentBik.DTO.CustomerDto;
import com.RentBikApp.RentBik.DTO.CustomerResponseDto;
import com.RentBikApp.RentBik.DTO.GplxDto;
import com.RentBikApp.RentBik.Model.Customer;
import com.RentBikApp.RentBik.Model.Gplx;
import com.RentBikApp.RentBik.Service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping("/customers")
    public List<CustomerResponseDto> findAllCustomer(){
        return customerService.findAllCustomer();
    }

    @PostMapping("/addCustomer")
    public Customer addUser(
            @RequestBody CustomerDto dto
    ){
        var customer = customerService.toCustomer(dto);
        return customerService.saveCustomer(customer, dto.gplxIds());
    }
}
