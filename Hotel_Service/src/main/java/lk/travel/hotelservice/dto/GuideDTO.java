package lk.travel.hotelservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GuideDTO {
    private String guideID;
    private String guideName;
    private String guideAddress;
    private int guideAge;
    private String guideGender;
    private String guideContactNo;
    private byte[] guideImage;
    private byte[] guideNICImage;
    private byte[] guideIDImage;
    private String guideExperience;
    private double guideManDayValue;
    private String guideRemarks;
}
