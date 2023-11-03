package lk.travel.vehicleservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Vehicle implements SuperEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String vehicleID;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "vehicle_brand",joinColumns = @JoinColumn(name = "vehicleID"))
    private List<VehicleBrand> vehicleBrand;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "vehicle_category",joinColumns = @JoinColumn(name = "vehicleID"))
    private List<VehicleCategory> vehicleCategory;
    @Column(nullable = false)
    private String fuelType;
    @Column(nullable = false)
    private boolean hybridOrNonHybrid;
    @Column(nullable = false)
    private String fuelUsage;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] vehicleImage;
    @Column(nullable = false)
    private int vehicleSeatCapacity;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "vehicle_type",joinColumns = @JoinColumn(name = "vehicleID"))
    private List<VehicleType> vehicleType;
    @Column(nullable = false)
    private String transmissionType;
    @Column(nullable = false)
    private String guideName;
    @Column(nullable = false)
    private String guideContactNo;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] guideLicenseScannedImage;
    @Column(nullable = false)
    private String vehicleRemarks;

    /*@JsonIgnore
    @OneToMany(mappedBy = "vehicle")
    private List<TravelBook> traveBookList;*/
}
