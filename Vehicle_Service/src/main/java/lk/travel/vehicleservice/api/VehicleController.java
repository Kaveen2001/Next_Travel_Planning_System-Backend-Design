package lk.travel.vehicleservice.api;

import lk.travel.vehicleservice.dto.VehicleDTO;
import lk.travel.vehicleservice.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/vehicle")
@RequiredArgsConstructor
public class VehicleController {
    private final VehicleService vehicleService;

    @PostMapping("/saveVehicle")
    public ResponseEntity<VehicleDTO> saveVehicle(@RequestBody VehicleDTO vehicleDTO) {
        return new ResponseEntity<>(vehicleService.saveVehicle(vehicleDTO), HttpStatus.OK);
    }

    @PostMapping(path = "image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<VehicleDTO> saveWithImageVehicle(@RequestPart String vehicleID, @RequestPart String vehicleBrand, @RequestPart String vehicleCategory, @RequestPart String fuelType, @RequestPart boolean hybridOrNonHybrid, @RequestPart String fuelUsage, @RequestPart byte[] vehicleImage, @RequestPart int vehicleSeatCapacity, @RequestPart String vehicleType, @RequestPart String transmissionType, @RequestPart String guideName, @RequestPart String guideContactNo, @RequestPart byte[] guideLicenseScannedImage, @RequestPart String vehicleRemarks) {
        return new ResponseEntity<>(vehicleService.saveWithImageVehicle(new VehicleDTO(vehicleID, vehicleBrand, vehicleCategory, fuelType, hybridOrNonHybrid, fuelUsage, vehicleImage, vehicleSeatCapacity, vehicleType, transmissionType, guideName, guideContactNo, guideLicenseScannedImage, vehicleRemarks)), HttpStatus.OK);
    }

    @PutMapping("/updateVehicle")
    public ResponseEntity<VehicleDTO> updateVehicle(@RequestBody VehicleDTO vehicleDTO) {
        return new ResponseEntity<>(vehicleService.updateVehicle(vehicleDTO), HttpStatus.OK);
    }

    @PutMapping(path = "image", params = "vehicleID", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<VehicleDTO> uploadImageVehicle(@RequestPart MultipartFile multipartFile, @RequestParam String vehicleID) throws IOException {
        VehicleDTO vehicleDTO = vehicleService.searchVehicle(vehicleID);
        vehicleDTO.setImage(multipartFile.getBytes());
        return new ResponseEntity<>(vehicleService.updateVehicle(vehicleDTO), HttpStatus.OK);
    }


    @GetMapping(path = "search", params = "vehicleID")
    public ResponseEntity<VehicleDTO> searchVehicle(@RequestParam String vehicleID) {
        return new ResponseEntity<>(vehicleService.searchVehicle(vehicleID), HttpStatus.OK);
    }

    @DeleteMapping("deleteVehicle/{vehicleID}")
    public ResponseEntity<VehicleDTO> deleteVehicle(@RequestParam String vehicleID) {
        vehicleService.deleteVehicle(vehicleID);
        return new ResponseEntity(null, HttpStatus.OK);
    }

    @GetMapping("/getAllVehicles")
    public ResponseEntity<List<VehicleDTO>> getAllVehicles() {
        return new ResponseEntity<>(vehicleService.getAllVehicles(), HttpStatus.OK);
    }
}
