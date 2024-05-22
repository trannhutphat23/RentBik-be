package com.RentBikApp.RentBik.Repository;

import com.RentBikApp.RentBik.Model.ReturnCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReturnCardRepository extends JpaRepository<ReturnCard, Integer> {
    @Query(nativeQuery = true,
            value = "select SUM(total) AS tien_tra_xe " +
                    "from return_card")
    Object getSumReturnPrice();
}
