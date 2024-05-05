package com.RentBikApp.RentBik.Service;

import com.RentBikApp.RentBik.DTO.InsuranceDto;
import com.RentBikApp.RentBik.Model.ErrorResponse;
import com.RentBikApp.RentBik.Model.Insurance;
import com.RentBikApp.RentBik.Repository.InsuranceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsuranceService {
    private final InsuranceRepository insuranceRepository;

    public InsuranceService(InsuranceRepository insuranceRepository) {
        this.insuranceRepository = insuranceRepository;
    }

    public Object addInsurance(InsuranceDto dto){
        var insurance = toInsurance(dto);

        // check mabh
        if (insuranceRepository.existsByMabh(insurance.getMabh())){
            return new ErrorResponse("Mabh must be unique");
        }

        return insuranceRepository.save(insurance);
    }

    public List<Insurance> findAllInsurance(){
        return insuranceRepository.findAll();
    }

    private Insurance toInsurance(InsuranceDto dto){
        var insurance = new Insurance();
        insurance.setMabh(dto.mabh());
        insurance.setPurchaseDate(dto.purchaseDate());
        insurance.setExpiredDate(dto.expiredDate());
        insurance.setPurchasePrice(dto.purchasePrice());
        return insurance;
    }

    public Insurance findInsuranceById(Integer id){
        return insuranceRepository.findById(id)
                .orElse(null);
    }
}
