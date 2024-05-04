package com.RentBikApp.RentBik.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.RentBikApp.RentBik.Model.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    boolean existsByCccd(String cccd);
    boolean existsByPhoneNumber(String phoneNumber);
}
