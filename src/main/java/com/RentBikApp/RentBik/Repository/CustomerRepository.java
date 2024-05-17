package com.RentBikApp.RentBik.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.RentBikApp.RentBik.Model.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    boolean existsByCccd(String cccd);
    boolean existsByPhoneNumber(String phoneNumber);
    @Query(nativeQuery = true,
            value = "SELECT t1.*, t3.rank " +
                    "FROM public.customer t1 " +
                    "INNER JOIN public.customer_gplx t2 ON t1.id = t2.customer_id " +
                    "INNER JOIN public.gplx t3 ON t2.gplx_id = t3.id " +
                    "WHERE (t1.cccd ILIKE %:cccd%)"
    )
    Customer findAllByCccdContaining(String cccd);
    @Query(nativeQuery = true,
        value = "SELECT * FROM public.customer t WHERE t.cccd LIKE %:keyword% " +
                                                "OR t.fullname LIKE %:keyword% " +
                                                "OR t.note LIKE %:keyword% " +
                                                "OR t.phone_number LIKE %:keyword%"
    )
    List<Customer> findByKeywordContainingIgnoreCase(String keyword);
}
