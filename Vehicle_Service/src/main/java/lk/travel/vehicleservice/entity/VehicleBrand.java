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
public class VehicleBrand implements SuperEntity {
    @Column(nullable = false)
    private String nissanCaravan;
    @Column(nullable = false)
    private String suzukiCelerio;
    @Column(nullable = false)
    private String toyotaAlphard;
    @Column(nullable = false)
    private String toyotaCoaster;
    @Column(nullable = false)
    private String toyotaYaris;
    @Column(nullable = false)
    private String toyotaPradoVXV8;
}
