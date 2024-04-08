package com.RentBikApp.RentBik.DTO;

import com.RentBikApp.RentBik.Model.Gplx;

import java.util.Set;

public record CustomerResponseDto(
        Integer id,
        String cccd,
        String fullname,
        String birthday,
        String phoneNumber,
        Set<GplxResponseDto> gplxes,
        String note
) {
}
