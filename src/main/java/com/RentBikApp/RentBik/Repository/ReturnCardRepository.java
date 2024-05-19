package com.RentBikApp.RentBik.Repository;

import com.RentBikApp.RentBik.Model.ReturnCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReturnCardRepository extends JpaRepository<ReturnCard, Integer> {
}
