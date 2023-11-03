package lk.travel.customerservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO {
    private String customerID;
    private String customerName;
    private String customerNICNo;
    private byte[] customerNICImage;
    private int customerAge;
    private String customerGender;
    private String customerAddress;
    private String customerEmailAddress;
    private String customerContactNo;
    private byte[] customerImage;
    private String customerRemarks;

    @JsonIgnore
    private List<BookingDTO> bookingList;
}
