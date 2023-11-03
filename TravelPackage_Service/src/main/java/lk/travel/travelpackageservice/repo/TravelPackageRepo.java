package lk.travel.travelpackageservice.repo;

import lk.travel.travelpackageservice.entity.TravelPackage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelPackageRepo extends JpaRepository<TravelPackage,String> {

}
