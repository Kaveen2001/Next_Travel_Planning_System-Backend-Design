package lk.travel.bookingservice.repo;

import lk.travel.bookingservice.entity.Payments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentsRepo extends JpaRepository<Payments,String> {
}
