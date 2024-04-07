package com.RentBikApp.RentBik.Controller;

import com.RentBikApp.RentBik.Model.Brand;
import com.RentBikApp.RentBik.Model.Series;
import com.RentBikApp.RentBik.Service.SeriesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1")
public class SeriesController {
    private final SeriesService seriesService;

    public SeriesController(SeriesService seriesService) {
        this.seriesService = seriesService;
    }

    @GetMapping("/series")
    public List<Series> findAllSeries(){
        return seriesService.findAllBrands();
    }

    @PostMapping("/addSeries")
    public Series addSeries(
            @RequestBody Series series
    ){
        return seriesService.addSeries(series);
    }
}
