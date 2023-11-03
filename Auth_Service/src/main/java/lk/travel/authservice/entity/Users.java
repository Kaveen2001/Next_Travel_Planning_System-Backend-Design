package lk.travel.authservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Pattern(regexp = "^(U00-)[0-9]{1,3}$")
    private String userID;
    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private String userPassword;
    @Email
    @Column(nullable = false,unique = true)
    private String userEmail;
    @Enumerated(EnumType.STRING)
    private Role role;

}
