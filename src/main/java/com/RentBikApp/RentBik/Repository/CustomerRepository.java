package com.RentBikApp.RentBik.Repository;

import com.RentBikApp.RentBik.DTO.CustomerDto;
import com.RentBikApp.RentBik.DTO.CustomerResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import com.RentBikApp.RentBik.Model.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    boolean existsByCccd(String cccd);
    boolean existsByPhoneNumber(String phoneNumber);
    Customer findAllByCccdContaining(String cccd);

    @Query(nativeQuery = true,
        value = "SELECT * FROM public.customer t WHERE t.cccd LIKE %:keyword% " +
                                                "OR t.fullname LIKE %:keyword% " +
                                                "OR t.note LIKE %:keyword% " +
                                                "OR t.phone_number LIKE %:keyword%"
    )
    List<Customer> findByKeywordContainingIgnoreCase(String keyword);
}
