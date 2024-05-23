package com.RentBikApp.RentBik.Repository;

import com.RentBikApp.RentBik.Model.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, Integer> {
    List<Insurance> findAllByOrderByIdAsc();
    boolean existsByMabh(String mabh);

    @Query(nativeQuery = true,
        value = "SELECT SUM(purchase_price) AS tien_bao_hiem " +
                "FROM insurance"
    )
    Object getReportInsurance();
}
