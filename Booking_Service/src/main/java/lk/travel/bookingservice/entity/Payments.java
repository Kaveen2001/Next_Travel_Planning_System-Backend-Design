package lk.travel.bookingservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lk.travel.bookingservice.dto.BookingDTO;
import lk.travel.customerservice.entity.Booking;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@DynamicUpdate
public class Payments implements SuperEntity{

    @Id
    private String cardNo;
    @Column(nullable = false)
    private String cardName;
    @Column(nullable = false)
    private String expMonth;
    @Column(nullable = false)
    private int expYear;
    @Column(nullable = false)
    private String cwCode;

    @JsonIgnore
    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(mappedBy = "payments")
    private List<Booking> bookingList;
}
