package lk.travel.travelpackageservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PackageCategoryDTO {

    private String regularPackage;
    private String midLevelPackage;
    private String luxuryPackage;
    private String superLuxuryPackage;

    @JsonIgnore
    private List<TravelPackageDTO> travelPackageDTO;
}
