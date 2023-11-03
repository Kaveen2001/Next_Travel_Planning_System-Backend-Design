package lk.travel.hotelservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HotelDTO {

   private String hotelID;
   private String hotelName;
   private List<HotelCategoryDTO> hotelCategory;
   private String hotelLocation;
   private String hotelLocationWithCoordinates;
   private String hotelContactEmail;
   private String hotelContactNo1;
   private String hotelContactNo2;
   private byte[] hotelImage;
   private boolean petsAllowedorNot;
   private double hotelFee;
   private String hotelCancellationCriteria;
   private String hotelRemarks;
}
