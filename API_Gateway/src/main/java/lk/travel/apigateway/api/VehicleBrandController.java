package lk.travel.apigateway.api;

import lk.travel.apigateway.constant.SecurityConstant;
import lk.travel.apigateway.dto.VehicleBrandDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/gateway/vehicle/brand")
@RequiredArgsConstructor
public class VehicleBrandController {
    private final String URL = SecurityConstant.URL+"8085/api/v1/vehicle/brand";
    @PostMapping
    public Mono<VehicleBrandDTO> saveVehicleBrand(@RequestHeader MultiValueMap<String, String> headers, @RequestBody VehicleBrandDTO vehicleBrandDTO) {
        return WebClient.create(URL).post().body(Mono.just(vehicleBrandDTO), VehicleBrandDTO.class).headers(h -> h.addAll(headers)).retrieve().bodyToMono(VehicleBrandDTO.class);
    }

    @PutMapping
    public ResponseEntity<VehicleBrandDTO> updateVehicleBrand(@RequestHeader MultiValueMap<String, String> headers, @RequestBody VehicleBrandDTO vehicleBrandDTO) {
        return WebClient.create(URL).put().body(Mono.just(vehicleBrandDTO), VehicleBrandDTO.class).headers(h -> h.addAll(headers)).retrieve().toEntity(VehicleBrandDTO.class).block();
    }


    @GetMapping(path = "search/{vehicleID}")
    public ResponseEntity searchVehicleBrand(@RequestHeader MultiValueMap<String, String> headers, @PathVariable("vehicleID") int vehicleID) {
        try {
            return WebClient.create(URL + "/search/" + vehicleID).get().headers(h -> h.addAll(headers)).retrieve().toEntity(VehicleBrandDTO.class).block();

        } catch (Exception e) {
            throw new RuntimeException("VehicleBrand Not Exists..!!");
        }
    }



    @DeleteMapping(params = "vehicleID")
    public ResponseEntity<Void> deleteVehicleBrand(@RequestHeader MultiValueMap<String, String> headers, @RequestParam int vehicleID) {
        return WebClient.create(URL + "/" + vehicleID).delete().headers(h -> h.addAll(headers)).retrieve().toEntity(Void.class).block();

    }

    @GetMapping
    public ResponseEntity getAllVehicleBrand(@RequestHeader MultiValueMap<String, String> headers) {
        return WebClient.create(URL).get().headers(h -> h.addAll(headers)).retrieve().toEntity(VehicleBrandDTO[].class).block();
    }
}
