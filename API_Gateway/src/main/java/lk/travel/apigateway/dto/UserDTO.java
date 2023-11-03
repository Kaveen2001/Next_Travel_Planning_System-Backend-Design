package lk.travel.apigateway.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    private String userID;
    private String userName;
    private String userPassword;
    private String userEmail;
    private RoleDTO role;
}
