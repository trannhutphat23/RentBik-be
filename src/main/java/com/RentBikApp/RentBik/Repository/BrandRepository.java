package com.RentBikApp.RentBik.Repository;

import com.RentBikApp.RentBik.Model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {
    List<Brand> findAllByNameContaining(String name);
    boolean existsByName(String name);
//    @Query(nativeQuery = true, value =
//            "DO $$ " +
//                    "BEGIN " +
//                    "    IF EXISTS (SELECT 1 FROM pg_constraint WHERE conrelid = (SELECT oid FROM pg_class WHERE relname = 'CAR' AND relnamespace = (SELECT oid FROM pg_namespace WHERE nspname = 'public')) AND conname IN ('car_brand_id_key', 'car_insurance_id_key', 'car_series_id_key', 'car_type_id_key')) THEN " +
//                    "        ALTER TABLE public.CAR DROP CONSTRAINT car_brand_id_key; " +
//                    "        ALTER TABLE public.CAR DROP CONSTRAINT car_insurance_id_key; " +
//                    "        ALTER TABLE public.CAR DROP CONSTRAINT car_series_id_key; " +
//                    "        ALTER TABLE public.CAR DROP CONSTRAINT car_type_id_key; " +
//                    "    END IF; " +
//                    "END $$"
//    )
//    void dropConstraints();
//
//    @Query(nativeQuery = true, value = "SELECT * FROM public.brand")
//    List<Brand> findAllBrands();
}
