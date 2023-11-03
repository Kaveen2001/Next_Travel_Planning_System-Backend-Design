package lk.travel.travelpackageservice.api;

import lk.travel.travelpackageservice.dto.TravelPackageDTO;
import lk.travel.travelpackageservice.service.TravelPackageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/travelPackage")
@RequiredArgsConstructor
public class TravelPackageController {

    private final TravelPackageService travelPackageService;

    @PostMapping("/saveTravelPackage")
    public ResponseEntity<TravelPackageDTO> saveTravelPackage(@RequestBody TravelPackageDTO travelPackageDTO) {
        return new ResponseEntity<>(travelPackageService.saveTravelPackage(travelPackageDTO), HttpStatus.OK);
    }

    @PutMapping("/updateTravelPackage")
    public ResponseEntity<TravelPackageDTO> updateTravelPackage(@RequestBody TravelPackageDTO travelPackageDTO) {
        return new ResponseEntity<>(travelPackageService.updateTravelPackage(travelPackageDTO), HttpStatus.OK);
    }

    @GetMapping(path = "search", params = "packageID")
    public ResponseEntity<TravelPackageDTO> searchTravelPackage(@RequestParam String packageID) {
        return new ResponseEntity<>(travelPackageService.searchTravelPackage(packageID), HttpStatus.OK);
    }

    @DeleteMapping(path = "deleteTravelPackage/{packageID}")
    public ResponseEntity<TravelPackageDTO> deleteTravelPackage(@PathVariable String packageID) {
        travelPackageService.deleteTravelPackage(packageID);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/getAllTravelPackages")
    public ResponseEntity<List<TravelPackageDTO>> getAllTravelPackages() {
        return new ResponseEntity<>(travelPackageService.getAllTravelPackages(), HttpStatus.OK);
    }
}
