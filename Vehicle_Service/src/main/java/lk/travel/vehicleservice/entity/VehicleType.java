package lk.travel.vehicleservice.entity;

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
public class VehicleType implements SuperEntity {
    @Column(nullable = false)
    private String car;
    @Column(nullable = false)
    private String van7_12seats;
    @Column(nullable = false)
    private String suv;
    @Column(nullable = false)
    private String bus30_40seats;
}
