package com.RentBikApp.RentBik.Service;

import com.RentBikApp.RentBik.DTO.GplxResponseDto;
import com.RentBikApp.RentBik.Model.Gplx;
import com.RentBikApp.RentBik.Repository.GplxRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GplxService {
    private final GplxRepository gplxRepository;

    public GplxService(GplxRepository gplxRepository) {
        this.gplxRepository = gplxRepository;
    }

    public GplxResponseDto saveGplx(Gplx gplx){
        gplxRepository.save(gplx);
        return toGplxResponseDto(gplx);
    }
    private GplxResponseDto toGplxResponseDto(Gplx gplx){
        return new GplxResponseDto(
            gplx.getId(),
            gplx.getRank()
        );
    }
    public List<Gplx> findAllGplx(){
        return gplxRepository.findAll();
    }
}
