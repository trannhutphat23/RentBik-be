package com.RentBikApp.RentBik.Repository;

import com.RentBikApp.RentBik.Model.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNullApi;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaintenanceRepository extends JpaRepository<Maintenance, Integer> {
//    boolean existsById(Integer id);
    @Query(nativeQuery = true,
            value = "SELECT t1.*, t2.license_plate " +
                    "FROM public.maintenance t1 " +
                    "INNER JOIN public.car t2 ON t1.car_id = t2.id " +
                    "WHERE (license_plate ILIKE %:keyword% OR maintenance_note ILIKE %:keyword% OR t1.status ILIKE %:keyword%)")
    List<Maintenance> findByKeywordContainingIgnoreCase(String keyword);
}
