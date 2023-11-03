package lk.travel.travelpackageservice.entity;

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
public class TravelArea implements SuperEntity {
   @Column(nullable = false)
   private String kandy;
   @Column(nullable = false)
   private String upcountry;
   @Column(nullable = false)
   private String easternCoast;
   @Column(nullable = false)
   private String capitalColombo;
   @Column(nullable = false)
   private String westernCoast;
   @Column(nullable = false)
   private String northPeninsula;
   @Column(nullable = false)
   private String downSouth;
   @Column(nullable = false)
   private String sigiriya;
   @Column(nullable = false)
   private String dambulla;
   @Column(nullable = false)
   private String anuradhapura;
   @Column(nullable = false)
   private String polonnaruwa;
   @Column(nullable = false)
   private String matale;
}
