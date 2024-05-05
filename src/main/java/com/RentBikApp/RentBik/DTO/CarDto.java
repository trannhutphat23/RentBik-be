package com.RentBikApp.RentBik.DTO;

import com.RentBikApp.RentBik.Model.Brand;
import com.RentBikApp.RentBik.Model.Insurance;
import com.RentBikApp.RentBik.Model.Series;
import com.RentBikApp.RentBik.Model.Type;

import java.time.LocalDate;

public record CarDto(
        String licensePlate,
        Integer type,
        Integer brand,
        Integer series,
        Integer insurance,
        Float purchasePrice,
        LocalDate purchaseDate,
        String carNote
) {
}
