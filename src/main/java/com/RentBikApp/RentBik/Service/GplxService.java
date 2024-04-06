package com.RentBikApp.RentBik.Service;

import com.RentBikApp.RentBik.Controller.GplxController;
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

    public Gplx saveGplx(Gplx gplx){
        return gplxRepository.save(gplx);
    }

    public List<Gplx> findAllGpl(){
        return gplxRepository.findAll();
    }
}
