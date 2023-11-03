package lk.travel.travelpackageservice.service;

import lk.travel.travelpackageservice.dto.TravelPackageDTO;

import java.util.List;

public interface TravelPackageService {
    TravelPackageDTO saveTravelPackage(TravelPackageDTO travelPackageDTO);
    TravelPackageDTO updateTravelPackage(TravelPackageDTO travelPackageDTO);
    TravelPackageDTO searchTravelPackage(String packageID);
    void deleteTravelPackage(String packageID);
    List<TravelPackageDTO> getAllTravelPackages();
}
