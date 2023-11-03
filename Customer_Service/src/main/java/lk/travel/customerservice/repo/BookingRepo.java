package lk.travel.customerservice.repo;


import lk.travel.customerservice.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookingRepo extends JpaRepository<Booking,Integer> {
    List<Booking> findByCustomerCustomerID(String customerID);
    Optional<Booking> findById(String bookingID);
    void deleteById(String bookingID);
    boolean existsById(String bookingID);
}
