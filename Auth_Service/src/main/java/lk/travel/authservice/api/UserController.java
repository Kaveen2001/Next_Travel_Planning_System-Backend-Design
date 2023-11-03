package lk.travel.authservice.api;

import lk.travel.authservice.dto.UserDTO;
import lk.travel.authservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/saveUser")
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO) {
        userDTO.setUserPassword(passwordEncoder.encode(userDTO.getUserPassword()));
        return ResponseEntity.ok(userService.saveUser(userDTO));
    }

    @PutMapping("/updateUser")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO) {
        userDTO.setUserPassword(passwordEncoder.encode(userDTO.getUserPassword()));
        return ResponseEntity.ok(userService.updateUser(userDTO));
    }

    @GetMapping(path = "search/email", params = "email")
    public ResponseEntity<UserDTO> searchByEmailUser(@RequestParam String userEmail) {
        return ResponseEntity.ok(userService.searchByEmailUser(userEmail));
    }

    @GetMapping("search")
    public ResponseEntity<UserDTO> searchByIDUser(@RequestParam String userID) {
        return ResponseEntity.ok(userService.searchUser(userID));
    }

    @DeleteMapping(path = "deleteUser/{userID}")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable("userID") String userID) {
        userService.deleteUser(userID);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
}
