package com.RentBikApp.RentBik.Controller;

import com.RentBikApp.RentBik.DTO.GplxDto;
import com.RentBikApp.RentBik.DTO.GplxResponseDto;
import com.RentBikApp.RentBik.Model.Gplx;
import com.RentBikApp.RentBik.Service.GplxService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class GplxController {
    private final GplxService gplxService;

    public GplxController(GplxService gplxService) {
        this.gplxService = gplxService;
    }
    @PostMapping("/addGplx")
    public GplxResponseDto addGplx(
        @RequestBody GplxDto dto
    ){
        var gplx = toGplx(dto);
        return gplxService.saveGplx(gplx);
    }

    private Gplx toGplx(GplxDto dto){
        var gplx = new Gplx();
        gplx.setRank(dto.rank());

        return gplx;
    }

    @GetMapping("/gplxs")
    public List<Gplx> findAllGplx(){
        return gplxService.findAllGplx();
    }
}
