package lk.travel.authservice.service;

import lk.travel.authservice.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO saveUser(UserDTO userDTO);
    UserDTO updateUser(UserDTO userDTO);
    UserDTO searchUser(String userID);
    UserDTO searchByEmailUser(String userEmail);
    void deleteUser(String userID);
    List<UserDTO> getAllUsers();
}
