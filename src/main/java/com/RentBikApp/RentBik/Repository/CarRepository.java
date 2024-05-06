package com.RentBikApp.RentBik.Repository;

import com.RentBikApp.RentBik.Model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
    boolean existsByLicensePlate(String licensePlate);

    @Query(value = "SELECT COALESCE(MAX(id), 0) FROM Car")
    Integer findMaxIndex();

    @Query(nativeQuery = true, value =
            "DO $$ " +
            "BEGIN " +
            "    IF EXISTS (SELECT 1 FROM pg_constraint WHERE conrelid = (SELECT oid FROM pg_class WHERE relname = 'CAR' AND relnamespace = (SELECT oid FROM pg_namespace WHERE nspname = 'public')) AND conname IN ('car_brand_id_key', 'car_insurance_id_key', 'car_series_id_key', 'car_type_id_key')) THEN " +
            "        ALTER TABLE public.CAR DROP CONSTRAINT car_brand_id_key; " +
            "        ALTER TABLE public.CAR DROP CONSTRAINT car_insurance_id_key; " +
            "        ALTER TABLE public.CAR DROP CONSTRAINT car_series_id_key; " +
            "        ALTER TABLE public.CAR DROP CONSTRAINT car_type_id_key; " +
            "    END IF; " +
            "END $$; " +
            "INSERT INTO public.CAR VALUES(:brandId, null, :index+1, :insuranceId, :purchaseDate, :purchasePrice, :seriesId, :typeId, :carNote, :licensePlate);")
    void saveCar(Integer brandId, Integer index, Integer insuranceId, LocalDate purchaseDate, Float purchasePrice, Integer seriesId, Integer typeId, String carNote, String licensePlate);
}
