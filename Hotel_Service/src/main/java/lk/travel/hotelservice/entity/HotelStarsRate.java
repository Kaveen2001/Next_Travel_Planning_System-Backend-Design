package lk.travel.hotelservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class HotelStarsRate implements SuperEntity{
   @Column(nullable = false)
   private String stars3Stars2;
   @Column(nullable = false)
   private String stars3Stars4;
   @Column(nullable = false)
   private String stars4Stars5;
   @Column(nullable = false)
   private String stars5;
}
