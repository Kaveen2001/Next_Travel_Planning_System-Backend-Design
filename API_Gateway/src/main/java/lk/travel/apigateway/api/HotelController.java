package lk.travel.apigateway.api;

import lk.travel.apigateway.constant.SecurityConstant;
import lk.travel.apigateway.dto.HotelDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/gateway/hotel")
@RequiredArgsConstructor
public class HotelController {
    private final String URL = SecurityConstant.URL+"8083/api/v1/hotel";
    @PostMapping
    public Mono<HotelDTO> saveHotel(@RequestHeader MultiValueMap<String, String> headers, @RequestBody HotelDTO hotelDTO) {
        return WebClient.create(URL).post().body(Mono.just(hotelDTO), HotelDTO.class).headers(h -> h.addAll(headers)).retrieve().bodyToMono(HotelDTO.class);
    }

    @PutMapping
    public ResponseEntity<HotelDTO> updateHotel(@RequestHeader MultiValueMap<String, String> headers, @RequestBody HotelDTO hotelDTO) {
        return WebClient.create(URL).put().body(Mono.just(hotelDTO), HotelDTO.class).headers(h -> h.addAll(headers)).retrieve().toEntity(HotelDTO.class).block();
    }


    @GetMapping(path = "search/{hotelID}")
    public ResponseEntity searchHotel(@RequestHeader MultiValueMap<String, String> headers, @PathVariable("hotelID") int hotelID) {
        try {
            return WebClient.create(URL + "/search/" + hotelID).get().headers(h -> h.addAll(headers)).retrieve().toEntity(HotelDTO.class).block();

        } catch (Exception e) {
            throw new RuntimeException("Hotel Not Exists..!!");
        }
    }

    @GetMapping(path = "search/email", params = "email")
    public ResponseEntity<HotelDTO> searchEmailHotel(@RequestHeader MultiValueMap<String, String> headers, @RequestParam String email) {
        return WebClient.create(URL + "/search/email?email=" + email).get().headers(h -> h.addAll(headers)).retrieve().toEntity(HotelDTO.class).block();

    }

    @DeleteMapping(params = "hotelID")
    public ResponseEntity<Void> deleteHotel(@RequestHeader MultiValueMap<String, String> headers, @RequestParam int hotelID) {
        return WebClient.create(URL + "/" + hotelID).delete().headers(h -> h.addAll(headers)).retrieve().toEntity(Void.class).block();

    }

    @GetMapping
    public ResponseEntity getAllHotel(@RequestHeader MultiValueMap<String, String> headers) {
        return WebClient.create(URL).get().headers(h -> h.addAll(headers)).retrieve().toEntity(HotelDTO[].class).block();
    }
}
