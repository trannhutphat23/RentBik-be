package com.RentBikApp.RentBik.Controller;

import com.RentBikApp.RentBik.DTO.CustomerDto;
import com.RentBikApp.RentBik.DTO.CustomerResponseDto;
import com.RentBikApp.RentBik.DTO.GplxDto;
import com.RentBikApp.RentBik.Model.Customer;
import com.RentBikApp.RentBik.Model.Gplx;
import com.RentBikApp.RentBik.Service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
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

    @PostMapping("/customers/add")
    public Object addUser(
            @RequestBody CustomerDto dto
    ){
        return customerService.saveCustomer(dto, dto.gplxIds());
    }
    @DeleteMapping("/customers/{customer_id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomer(
            @PathVariable("customer_id") Integer id
    ){
        customerService.deleteCustomer(id);
    }
}
