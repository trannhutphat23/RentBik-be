package com.RentBikApp.RentBik.Repository;

import com.RentBikApp.RentBik.Model.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentRepository extends JpaRepository<Rent, Integer> {
}
