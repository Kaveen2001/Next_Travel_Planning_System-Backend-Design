package lk.travel.travelpackageservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lk.travel.travelpackageservice.entity.PackageCategory;
import lk.travel.travelpackageservice.entity.TravelArea;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TravelPackageDTO {

    private String packageID;
    private List<PackageCategoryDTO> packageCategoryDTO;
    @JsonFormat(pattern = "yyy-MM-dd")
    private LocalDate travelStartDate;
    @JsonFormat(pattern = "yyy-MM-dd")
    private LocalDate travelEndDate;
    private int countOfDays;
    private int countOfNights;
    private List<TravelAreaDTO> travelAreaDTO;
    private String travelerType;
    private int totalHeadCount;
    private boolean withPetOrNot;
    private boolean needGuideOrNot;
    private String customerID;
    private double packageValue;
    private double packagePaidValue;
    private String packageRemarks;
}
