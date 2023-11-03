package lk.travel.apigateway.api;

import lk.travel.apigateway.constant.SecurityConstant;
import lk.travel.apigateway.dto.GuideDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("api/v1/gateway/guide")
@RequiredArgsConstructor
public class GuideController {

   final private RestTemplate restTemplate;
    private final String URL = SecurityConstant.URL+"8083/api/v1/guide";
    @PostMapping
    public ResponseEntity<GuideDTO> saveGuide(@RequestHeader  MultiValueMap<String ,String> header, @RequestBody GuideDTO guideDTO) {

        return WebClient.create(URL).post().body(guideDTO, GuideDTO.class).headers(h->h.addAll(header))
                .retrieve().toEntity(GuideDTO.class).block();
    }
    @PutMapping
    public ResponseEntity<GuideDTO> updateGuide(@RequestHeader MultiValueMap<String, String> headers, @RequestBody GuideDTO guideDTO) {
    return WebClient.create(URL).post().body(guideDTO, GuideDTO.class).headers(h->h.addAll(headers))
                .retrieve().toEntity(GuideDTO.class).block();

    }


    @GetMapping(path = "search/{guideID}")
    public ResponseEntity<GuideDTO> searchGuide(@RequestHeader MultiValueMap<String, String> headers,@PathVariable("guideID") int guideID) {
        try {

            return WebClient.create(URL+"/search"+guideID).get().headers(h->h.addAll(headers)).retrieve().toEntity(GuideDTO.class).block();

        }catch (Exception e){
            throw new RuntimeException("Guide Not Exists..!!");
        }
    }
    @GetMapping(path = "search/email", params = "email")
    public ResponseEntity<GuideDTO> searchEmailGuide(@RequestHeader MultiValueMap<String, String> headers,@RequestParam String email) {
        return restTemplate.exchange(URL+"/search/email?email="+email, HttpMethod.GET, new HttpEntity<>(headers), GuideDTO.class);

    }

    @DeleteMapping(params = "{guideID}")
    public ResponseEntity<GuideDTO> deleteGuide(@RequestHeader MultiValueMap<String, String> headers,@PathVariable("guideID") int guideID) {
        return restTemplate.exchange(URL+"/"+guideID, HttpMethod.DELETE, new HttpEntity<>(headers), GuideDTO.class);

    }

    @GetMapping
    public ResponseEntity getAllGuide(@RequestHeader MultiValueMap<String, String> headers) {
        return WebClient.create(URL).get().headers(h->h.addAll(headers)).retrieve().toEntity(GuideDTO[].class).block();

    }

}
