package com.RentBikApp.RentBik.Service;

import com.RentBikApp.RentBik.Model.Brand;
import com.RentBikApp.RentBik.Model.Series;
import com.RentBikApp.RentBik.Repository.SeriesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeriesService {
    private final SeriesRepository seriesRepository;
    public SeriesService(SeriesRepository seriesRepository) {
        this.seriesRepository = seriesRepository;
    }
    public List<Series> findAllBrands(){
        return seriesRepository.findAll();
    }
    public Series addSeries(Series series){
        return seriesRepository.save(series);
    }
}
