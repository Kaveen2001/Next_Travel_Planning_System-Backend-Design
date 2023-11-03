package lk.travel.authservice.repo;

import lk.travel.authservice.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<Users,String> {
    Optional<Users> findByEmail(String userEmail);
}
