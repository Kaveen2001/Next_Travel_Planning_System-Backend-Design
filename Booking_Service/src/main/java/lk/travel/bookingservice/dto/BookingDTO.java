package lk.travel.bookingservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lk.travel.apigateway.dto.CustomerDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingDTO {

    private String bookingID;
    @JsonFormat(pattern = "yyy-MM-dd")
    private LocalDate bookingDate;
    @JsonFormat(pattern = "HH:mm")
    private LocalTime bookingTime;
    private double packagePaidValue;
    private boolean paymentsStatus;
    private String travelID;
    private String hotelID;
    private String vehicleID;
    private String guideID;

    private CustomerDTO customerDTO;
    private PaymentsDTO paymentsDTO;
}
