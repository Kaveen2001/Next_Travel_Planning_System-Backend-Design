package lk.travel.apigateway.api;

import lk.travel.apigateway.constant.SecurityConstant;
import lk.travel.apigateway.dto.TravelDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/gateway/travel")
@RequiredArgsConstructor
public class TravelController {
    private final String URL = SecurityConstant.URL+"8084/api/v1/travel";
    @PostMapping("/saveTravel")
    public Mono<TravelDTO> saveTravel(@RequestHeader MultiValueMap<String, String> headers, @RequestBody TravelDTO travelDTO) {
        return WebClient.create(URL).post().body(Mono.just(travelDTO), TravelDTO.class).headers(h -> h.addAll(headers)).retrieve().bodyToMono(TravelDTO.class);
    }

    @PutMapping("/updateTravel")
    public ResponseEntity<TravelDTO> updateTravel(@RequestHeader MultiValueMap<String, String> headers, @RequestBody TravelDTO travelDTO) {
        return WebClient.create(URL).put().body(Mono.just(travelDTO), TravelDTO.class).headers(h -> h.addAll(headers)).retrieve().toEntity(TravelDTO.class).block();
    }


    @GetMapping(path = "search/{travelID}")
    public ResponseEntity searchTravel(@RequestHeader MultiValueMap<String, String> headers, @PathVariable("travelID") int travelID) {
        try {
            return WebClient.create(URL + "/search/" + travelID).get().headers(h -> h.addAll(headers)).retrieve().toEntity(TravelDTO.class).block();

        } catch (Exception e) {
            throw new RuntimeException("Travel Not Exists..!!");
        }
    }



    @DeleteMapping("deleteTravel/{travelID}")
    public ResponseEntity<Void> deleteTravel(@RequestHeader MultiValueMap<String, String> headers, @RequestParam int travelID) {
        return WebClient.create(URL + "/" + travelID).delete().headers(h -> h.addAll(headers)).retrieve().toEntity(Void.class).block();

    }

    @GetMapping("/getAllTravels")
    public ResponseEntity getAllTravel(@RequestHeader MultiValueMap<String, String> headers) {
        return WebClient.create(URL).get().headers(h -> h.addAll(headers)).retrieve().toEntity(TravelDTO[].class).block();
    }
}
