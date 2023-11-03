package lk.travel.travelpackageservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class TravelPackage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Pattern(regexp = "^(P00-)[0-9]{1,3}$")
    private String packageID;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "package_category",joinColumns = @JoinColumn(name = "packageID"))
    private List<PackageCategory> packageCategory;
    @Column(nullable = false,unique = true)
    private LocalDate travelStartDate;
    @Column(nullable = false)
    private LocalDate travelEndDate;
    @Column(nullable = false,unique = true)
    private int countOfDays;
    @Column(nullable = false,unique = true)
    private int countOfNights;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "travel_area",joinColumns = @JoinColumn(name = "packageID"))
    private List<TravelArea> travelAreas;
    @Column(nullable = false,unique = true)
    private String travelerType;
    @Column(nullable = false,unique = true)
    private int totalHeadCount;
    @Column(nullable = false,unique = true)
    private boolean withPetOrNot;
    @Column(nullable = false,unique = true)
    private boolean needGuideOrNot;
    @Column(nullable = false,unique = true)
    private String customerID;
    @Column(nullable = false)
    private double packageValue;
    @Column(nullable = false,unique = true)
    private double packagePaidValue;
    @Column(nullable = false)
    private String packageRemarks;
}
