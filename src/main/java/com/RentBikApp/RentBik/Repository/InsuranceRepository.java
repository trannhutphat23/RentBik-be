package com.RentBikApp.RentBik.Repository;

import com.RentBikApp.RentBik.Model.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, Integer> {
    boolean existsByMabh(String mabh);
}
