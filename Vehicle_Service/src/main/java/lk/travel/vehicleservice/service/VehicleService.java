package lk.travel.vehicleservice.service;

import lk.travel.vehicleservice.dto.VehicleDTO;

import java.util.List;

public interface VehicleService {
    VehicleDTO saveVehicle(VehicleDTO vehicleDTO);
    VehicleDTO saveWithImageVehicle(VehicleDTO vehicleDTO);
    VehicleDTO updateVehicle(VehicleDTO vehicleDTO);
    VehicleDTO searchVehicle(String vehicleID);
    void deleteVehicle(String vehicleID);
    List<VehicleDTO> getAllVehicles();
}
