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
public class HotelCategory implements SuperEntity{
   @Column(nullable = false)
   private String regular;
   @Column(nullable = false)
   private String midLevel;
   @Column(nullable = false)
   private String luxury;
   @Column(nullable = false)
   private String superLuxury;
}
