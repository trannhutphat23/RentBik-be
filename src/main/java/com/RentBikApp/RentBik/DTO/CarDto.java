package com.RentBikApp.RentBik.DTO;

import com.RentBikApp.RentBik.Model.Brand;
import com.RentBikApp.RentBik.Model.Insurance;
import com.RentBikApp.RentBik.Model.Series;
import com.RentBikApp.RentBik.Model.Type;

import java.time.LocalDate;

public record CarDto(
        String licensePlate,
        Integer typeId,
        Integer brandId,
        Integer seriesId,
        Integer insuranceId,
        Float purchasePrice,
        LocalDate purchaseDate,
        String carNote
) {
}