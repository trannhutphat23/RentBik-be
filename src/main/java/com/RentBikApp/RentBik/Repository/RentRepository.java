package com.RentBikApp.RentBik.Repository;

import com.RentBikApp.RentBik.DTO.RentResponseDto;
import com.RentBikApp.RentBik.Model.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface RentRepository extends JpaRepository<Rent, Integer> {

    // get expire date by customer_id and car_id
    @Query(nativeQuery = true,
            value = "SELECT expiry_date FROM public.RENT " +
                    "WHERE customer_id = %:customerId% AND car_id = %:carId%")
    LocalDate getExpiryDate(Integer customerId, Integer carId);

    // get info rent by bsx and cccd
    @Query(nativeQuery = true,
            value = "SELECT t1.*, t2.cccd, t3.status, t3.license_plate, t3.hire_price " +
                    "FROM public.RENT t1 " +
                    "INNER JOIN public.CUSTOMER t2 ON t1.customer_id = t2.id " +
                    "INNER JOIN public.CAR t3 ON t1.car_id = t3.id " +
                    "WHERE cccd = %:cccd% AND t3.license_plate = %:bsx% AND t3.status = 'Khong co san'")
    Rent findRentInfoDetail(String bsx, String cccd);
}
