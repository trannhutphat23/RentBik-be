package com.RentBikApp.RentBik.Repository;

import com.RentBikApp.RentBik.DTO.CarResponseDto;
import com.RentBikApp.RentBik.Model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
    boolean existsByLicensePlate(String licensePlate);
    @Query(nativeQuery = true,
            value = "SELECT t1.*, t3.name, t2.name " +
                    "FROM public.car t1 " +
                    "INNER JOIN public.series t2 ON t1.series_id = t2.id " +
                    "INNER JOIN public.type t3 ON t1.type_id = t3.id " +
                    "WHERE (license_plate ILIKE %:keyword% OR car_note ILIKE %:keyword% OR status ILIKE %:keyword% OR t2.name ILIKE %:keyword% OR t3.name ILIKE %:keyword%)"
    )
    List<Car> findByKeywordContainingIgnoreCase(String keyword);

    @Query(nativeQuery = true,
            value = "SELECT * FROM public.CAR " +
                    "WHERE insurance_id IS NULL ")
    List<Car> findCarHaveInsuranceNull();

    @Modifying
    @Transactional
    @Query(nativeQuery = true,
            value = "UPDATE public.CAR " +
                    "SET insurance_id = %:insuranceId% " +
                    "WHERE id = %:carId% ")
    void addNewInsurance(Integer carId, Integer insuranceId);
}
