package lk.travel.hotelservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class Guide {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Pattern(regexp = "^(G00-)[0-9]{1,3}$")
    private String guideID;
    @Column(nullable = false,unique = true)
    private String guideName;
    @Column(nullable = false)
    private String guideAddress;
    @Column(nullable = false,unique = true)
    private int guideAge;
    @Column(nullable = false,unique = true)
    private String guideGender;
    @Column(nullable = false,unique = true)
    private String guideContactNo;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] guideImage;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] guideNICImage;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] guideIDImage;
    @Column(nullable = false)
    private String guideExperience;
    @Column(nullable = false,unique = true)
    private double guideManDayValue;
    @Column(nullable = false)
    private String guideRemarks;
}
