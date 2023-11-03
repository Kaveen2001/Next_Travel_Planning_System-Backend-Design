package lk.travel.apigateway.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TravelLocationDTO {
    private String travelAreaName;
    private String remark;
}
