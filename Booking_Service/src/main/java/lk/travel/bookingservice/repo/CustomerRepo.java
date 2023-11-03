package lk.travel.bookingservice.repo;

import lk.travel.customerservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,String> {
    Customer findByEmail(String customerEmailAddress);
}
