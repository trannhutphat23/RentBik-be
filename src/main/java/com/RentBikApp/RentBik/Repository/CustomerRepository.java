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
                    "WHERE (t1.cccd ILIKE %:cccd%)" +
                    "LIMIT 1"
    )
    Customer findAllByCccdContaining(String cccd);
    @Query(nativeQuery = true,
        value = "SELECT * FROM public.customer t WHERE t.cccd LIKE %:keyword% " +
                                                "OR t.fullname LIKE %:keyword% " +
                                                "OR t.note LIKE %:keyword% " +
                                                "OR t.phone_number LIKE %:keyword%"
    )
    List<Customer> findByKeywordContainingIgnoreCase(String keyword);

    @Query(nativeQuery = true,
            value = "SELECT * " +
                    "FROM public.CUSTOMER " +
                    "WHERE cccd = %:cccd% ")
    Customer findByCCCD(String cccd);

    @Query(nativeQuery = true,
            value = "SELECT t1.id, t1.fullname, COUNT(DISTINCT t2.id) AS rent_count, COUNT(DISTINCT t3.rent_id) AS return_count, " +
                    "COUNT(DISTINCT CASE WHEN t2.rent_status = 'Dang thue' THEN t2.id END) AS dang_thue_count, " +
                    "COUNT(DISTINCT CASE WHEN t2.rent_status = 'Da thanh toan' THEN t2.id END) AS da_thanh_toan_count, " +
                    "COALESCE(SUM(t3.tong), 0) AS total_sum " +
                    "FROM public.CUSTOMER t1 " +
                    "LEFT JOIN public.RENT t2 ON t1.id = t2.customer_id " +
                    "LEFT JOIN ( " +
                    "SELECT rent_id, SUM(tong_tien) AS tong " +
                    "FROM ( " +
                    "SELECT rent_id, COUNT(*) AS rent_count, COALESCE(SUM(total), 0) AS tong_tien " +
                    "FROM public.RETURN_CARD " +
                    "GROUP BY rent_id " +
                    ") " +
                    "GROUP BY rent_id " +
                    ") t3 ON t2.id = t3.rent_id " +
                    "GROUP BY t1.id, t1.fullname " +
                    "ORDER BY t1.id;"
    )
    List<Object[]> getReportCustomer();
}
