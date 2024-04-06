package com.RentBikApp.RentBik.Service;

import com.RentBikApp.RentBik.Model.Customer;
import com.RentBikApp.RentBik.Repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);
    }
}
