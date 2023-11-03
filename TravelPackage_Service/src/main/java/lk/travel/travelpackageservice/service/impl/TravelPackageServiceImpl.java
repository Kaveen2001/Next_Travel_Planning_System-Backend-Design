package lk.travel.travelpackageservice.service.impl;

import lk.travel.travelpackageservice.dto.TravelPackageDTO;
import lk.travel.travelpackageservice.entity.TravelPackage;
import lk.travel.travelpackageservice.repo.TravelPackageRepo;
import lk.travel.travelpackageservice.service.TravelPackageService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TravelPackageServiceImpl implements TravelPackageService {

    private final TravelPackageRepo travelPackageRepo;
    private final ModelMapper modelMapper;

    @Override
    public TravelPackageDTO saveTravelPackage(TravelPackageDTO travelPackageDTO) {
        if(travelPackageRepo.existsById(travelPackageDTO.getPackageID())){
            throw new RuntimeException("Travel Package Already Exists..!!");
        }
        travelPackageRepo.save(modelMapper.map(travelPackageDTO, TravelPackage.class));
        return travelPackageDTO;
    }

    @Override
    public TravelPackageDTO updateTravelPackage(TravelPackageDTO travelPackageDTO) {
        if(!travelPackageRepo.existsById(travelPackageDTO.getPackageID())){
            throw new RuntimeException("Travel Package Not Exists..!!");
        }
        travelPackageRepo.save(modelMapper.map(travelPackageDTO, TravelPackage.class));
        return travelPackageDTO;
    }

    @Override
    public TravelPackageDTO searchTravelPackage(String packageID) {
        if(!travelPackageRepo.existsById(packageID)){
            throw new RuntimeException("Travel Package Not Exists..!!");
        }
        return modelMapper.map(travelPackageRepo.findById(packageID), TravelPackageDTO.class);
    }

    @Override
    public void deleteTravelPackage(String packageID) {
        if(!travelPackageRepo.existsById(packageID)){
            throw new RuntimeException("Travel Package Not Exists..!!");
        }
        travelPackageRepo.deleteById(packageID);
    }

    @Override
    public List<TravelPackageDTO> getAllTravelPackages() {
        return modelMapper.map(travelPackageRepo.findAll(),new TypeToken<List<TravelPackageDTO>>(){}.getType());
    }
}
