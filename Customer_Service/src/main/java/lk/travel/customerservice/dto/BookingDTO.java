package lk.travel.customerservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BookingDTO {
    private String bookingID;
    @JsonFormat(pattern = "yyy-MM-dd")
    private LocalDate bookingDate;
    @JsonFormat(pattern = "HH:mm")
    private LocalTime bookingTime;
    private double paidValue;
    private boolean paymentStatus;
    private String travelID;
    private String hotelID;
    private String vehicleID;
    private String guideID;

    private CustomerDTO customer;
}
