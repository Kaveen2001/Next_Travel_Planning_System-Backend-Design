package lk.travel.vehicleservice.service.impl;

import lk.travel.vehicleservice.dto.VehicleDTO;
import lk.travel.vehicleservice.entity.Vehicle;
import lk.travel.vehicleservice.repo.VehicleRepo;
import lk.travel.vehicleservice.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {
    private final VehicleRepo vehicleRepo;
    private final ModelMapper mapper;

    @Override
    public VehicleDTO saveVehicle(VehicleDTO vehicleDTO) {
        if (vehicleRepo.existsById(vehicleDTO.getVehicleID())) {
            throw new RuntimeException("Vehicle Brand Already Exists..!!");
        }
        vehicleRepo.save(mapper.map(vehicleDTO, Vehicle.class));
        return vehicleDTO;
    }

    @Override
    public VehicleDTO updateVehicle(VehicleDTO vehicleDTO) {
        if (!vehicleRepo.existsById(vehicleDTO.getVehicleID())) {
            throw new RuntimeException("Vehicle Brand Not Exists..!!");
        }
        vehicleRepo.save(mapper.map(vehicleDTO, Vehicle.class));
        return vehicleDTO;
    }

    @Override
    public VehicleDTO searchVehicle(String vehicleID) {
        if (!vehicleRepo.existsById(vehicleID)) {
            throw new RuntimeException("Vehicle Not Exists..!!");
        }
        return mapper.map( vehicleRepo.findById(vehicleID), VehicleDTO.class);
    }

    @Override
    public void deleteVehicle(String vehicleID) {
        if (!vehicleRepo.existsById(vehicleID)) {
            throw new RuntimeException("Vehicle Not Exists..!!");
        }
        vehicleRepo.deleteById(vehicleID);
    }

    @Override
    public List<VehicleDTO> getAllVehicles() {
        return mapper.map(vehicleRepo.findAll(), new TypeToken<List<VehicleDTO>>() {
        }.getType());
    }
}
