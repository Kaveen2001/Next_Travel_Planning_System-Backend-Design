package lk.travel.vehicleservice.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@ToString
public class VehicleDTO {
    private String vehicleID;
    private String vehicleBrand;
    private String vehicleCategory;
    private String fuelType;
    private boolean hybridOrNonHybrid;
    private String fuelUsage;
    private byte[] vehicleImage;
    private int vehicleSeatCapacity;
    private String vehicleType;
    private String transmissionType;
    private String guideName;
    private String guideContactNo;
    private byte[] guideLicenseScannedImage;
    private String vehicleRemarks;

    public void setImage(byte[] bytes) {
    }
}
