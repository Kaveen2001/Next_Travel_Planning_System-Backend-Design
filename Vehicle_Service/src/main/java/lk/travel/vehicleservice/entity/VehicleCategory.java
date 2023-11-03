package lk.travel.vehicleservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class VehicleCategory implements SuperEntity {
    @Column(nullable = false)
    private String economy;
    @Column(nullable = false)
    private String midRange;
    @Column(nullable = false)
    private String luxury;
    @Column(nullable = false)
    private String superLuxury;
}
