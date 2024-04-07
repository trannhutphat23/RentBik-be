package com.RentBikApp.RentBik.Controller;

import com.RentBikApp.RentBik.Model.Customer;
import com.RentBikApp.RentBik.Service.CustomerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/addCustomer")
    public Customer addUser(
            @RequestBody Customer customer
    ){
        System.out.println(customer);
        return customer;
//        return customerService.saveCustomer(customer);
    }
}
