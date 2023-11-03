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
public class HotelRoomType implements SuperEntity {
    @Column(nullable = false)
    private String FRDouble;
    @Column(nullable = false)
    private String HRDouble;
    @Column(nullable = false)
    private String FRTriple;
    @Column(nullable = false)
    private String HRTriple;
}
