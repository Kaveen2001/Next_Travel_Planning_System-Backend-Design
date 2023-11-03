package lk.travel.apigateway.api;

import lk.travel.apigateway.constant.SecurityConstant;
import lk.travel.apigateway.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/gateway/user")
@RequiredArgsConstructor
public class UserController {
    private final String URL = SecurityConstant.URL+"8081/api/v1/user";
    @PostMapping
    public Mono<UserDTO> saveUser(@RequestHeader MultiValueMap<String, String> headers, @RequestBody UserDTO userDTO) {
        return WebClient.create(URL).post().body(Mono.just(userDTO), UserDTO.class).headers(h -> h.addAll(headers)).retrieve().bodyToMono(UserDTO.class);
    }

    @PutMapping
    public ResponseEntity<UserDTO> updateUser(@RequestHeader MultiValueMap<String, String> headers, @RequestBody UserDTO userDTO) {
        return WebClient.create(URL).put().body(Mono.just(userDTO), UserDTO.class).headers(h -> h.addAll(headers)).retrieve().toEntity(UserDTO.class).block();
    }


    @GetMapping(path = "search/{userID}")
    public ResponseEntity searchUser(@RequestHeader MultiValueMap<String, String> headers, @PathVariable("userID") int userID) {
        try {
            return WebClient.create(URL + "/search/" + userID).get().headers(h -> h.addAll(headers)).retrieve().toEntity(UserDTO.class).block();

        } catch (Exception e) {
            throw new RuntimeException("User Not Exists..!!");
        }
    }



    @DeleteMapping(params = "userID")
    public ResponseEntity<Void> deleteUser(@RequestHeader MultiValueMap<String, String> headers, @RequestParam int userID) {
        return WebClient.create(URL + "/" + userID).delete().headers(h -> h.addAll(headers)).retrieve().toEntity(Void.class).block();

    }

    @GetMapping
    public ResponseEntity getAllUser(@RequestHeader MultiValueMap<String, String> headers) {
        return WebClient.create(URL).get().headers(h -> h.addAll(headers)).retrieve().toEntity(UserDTO[].class).block();
    }
}
