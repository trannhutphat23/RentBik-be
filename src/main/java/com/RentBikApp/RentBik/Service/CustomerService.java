package com.RentBikApp.RentBik.Service;

import com.RentBikApp.RentBik.DTO.CustomerDto;
import com.RentBikApp.RentBik.DTO.CustomerResponseDto;
import com.RentBikApp.RentBik.DTO.GplxDto;
import com.RentBikApp.RentBik.Model.Customer;
import com.RentBikApp.RentBik.Model.Gplx;
import com.RentBikApp.RentBik.Repository.CustomerRepository;
import com.RentBikApp.RentBik.Repository.GplxRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final GplxRepository gplxRepository;
    public CustomerService(CustomerRepository customerRepository, GplxRepository gplxRepository) {
        this.customerRepository = customerRepository;
        this.gplxRepository = gplxRepository;
    }
    public Customer saveCustomer(Customer customer, Set<Integer> gplxIds){
        Set<Gplx> gplxs = gplxRepository.findAllById(gplxIds).stream().collect(Collectors.toSet());
        customer.setGplxs(gplxs);
        return customerRepository.save(customer);
    }
    public Customer toCustomer(CustomerDto dto){
        var customer = new Customer();
        customer.setCccd(dto.cccd());
        customer.setFullname(dto.fullname());
        customer.setBirthday(dto.birthday());
        customer.setPhoneNumber(dto.phoneNumber());
        customer.setNote(dto.note());
        return customer;
    }
    private Gplx toGplx(GplxDto dto){
        var gplx = new Gplx();
        gplx.setRank(dto.rank());
        return gplx;
    }
    public List<CustomerResponseDto> findAllCustomer(){
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map(this::toCustomerResponseDto)
                .collect(Collectors.toList());
    }

    private CustomerResponseDto toCustomerResponseDto(Customer customer){
        return new CustomerResponseDto(
          customer.getId(),
          customer.getCccd(),
          customer.getFullname(),
          customer.getBirthday(),
          customer.getPhoneNumber(),
          customer.getGplxs(),
          customer.getNote()
        );
    }

    public void deleteCustomer(Integer id){
        customerRepository.deleteById(id);
    }
}
