package lk.travel.bookingservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentsDTO {

    private String cardNo;
    private String cardName;
    private String expMonth;
    private int expYear;
    private String cwCode;

    @JsonIgnore
    private List<BookingDTO> bookingDTO;
}
