package lk.travel.travelpackageservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TravelAreaDTO {

    private String kandy;
    private String upcountry;
    private String easternCoast;
    private String capitalColombo;
    private String westernCoast;
    private String northPeninsula;
    private String downSouth;
    private String sigiriya;
    private String dambulla;
    private String anuradhapura;
    private String polonnaruwa;
    private String matale;

    @JsonIgnore
    private List<TravelPackageDTO> travelPackageDTO;
}
