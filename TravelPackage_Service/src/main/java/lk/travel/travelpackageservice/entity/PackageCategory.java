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
public class PackageCategory implements SuperEntity {
   @Column(nullable = false)
   private String regularPackage;
   @Column(nullable = false)
   private String midLevelPackage;
   @Column(nullable = false)
   private String luxuryPackage;
   @Column(nullable = false)
   private String superLuxuryPackage;
}
