package lk.travel.hotelservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@DynamicUpdate
public class Hotel implements SuperEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Pattern(regexp = "^(H00-)[0-9]{1,3}$")
    private String hotelID;
    @Column(nullable = false)
    private String hotelName;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "hotel_starsRate",joinColumns = @JoinColumn(name = "hotelID"))
    private List<HotelStarsRate> hotelStarsRates;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "hotel_category",joinColumns = @JoinColumn(name = "hotelID"))
    private List<HotelCategory> hotelCategory;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "hotel_roomType",joinColumns = @JoinColumn(name = "hotelID"))
    private List<HotelRoomType> hotelRoomType;
    @Column(nullable = false)
    private String hotelLocation;
    @Column(nullable = false)
    private String hotelLocationWithCoordinates;
    @Email
    @Column(nullable = false,unique = true)
    private String hotelContactEmail;
    @Column(nullable = false)
    private String hotelContactNo1;
    @Column(nullable = false)
    private String hotelContactNo2;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] hotelImage;
    @Column(nullable = false)
    private boolean petsAllowedorNot;
    @Column(nullable = false)
    private double hotelFee;
    @Column(nullable = false)
    private String hotelCancellationCriteria;
    @Column(nullable = false)
    private String hotelRemarks;
}
