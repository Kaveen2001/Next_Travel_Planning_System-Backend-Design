package lk.travel.customerservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lk.travel.bookingservice.entity.Payments;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@DynamicUpdate
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Pattern(regexp = "^(B00-)[0-9]{1,3}$")
    private String bookingID;
    @Column(nullable = false)
    private LocalDate bookingDate;
    @Column(nullable = false)
    private LocalTime bookingTime;
    @Column(nullable = false)
    private double paidValue;
    @Column(nullable = false)
    private boolean paymentStatus;
    @Column(nullable = false)
    private String travelID;
    @Column(nullable = false)
    private String hotelID;
    @Column(nullable = false)
    private String vehicleID;
    @Column(nullable = false)
    private String guideID;

    @ManyToOne
    @JoinColumn(name = "customerID")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "cardNo")
    private Payments payments;
}
