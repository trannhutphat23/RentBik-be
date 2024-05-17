package com.RentBikApp.RentBik.Repository;

import com.RentBikApp.RentBik.Model.PaymentMaintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMaintenanceRepository extends JpaRepository<PaymentMaintenance, Integer> {

}
