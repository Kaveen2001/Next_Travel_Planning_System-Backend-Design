package lk.travel.vehicleservice.repo;

import lk.travel.vehicleservice.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepo extends JpaRepository<Vehicle, String> {
}
