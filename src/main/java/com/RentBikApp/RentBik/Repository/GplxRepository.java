package com.RentBikApp.RentBik.Repository;

import com.RentBikApp.RentBik.Model.Gplx;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GplxRepository extends JpaRepository<Gplx, Integer> {
}
