package lk.travel.customerservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@DynamicUpdate
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Pattern(regexp = "^(C00-)[0-9]{1,3}$")
    private String customerID;
    @Column(nullable = false,unique = true)
    private String customerName;
    @Column(nullable = false)
    private String customerNICNo;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] customerNICImage;
    @Column(nullable = false,unique = true)
    private int customerAge;
    @Column(nullable = false)
    private String customerGender;
    @Column(nullable = false)
    private String customerAddress;
    @Email
    @Column(nullable = false,unique = true)
    private String customerEmailAddress;
    @Column(nullable = false,unique = true)
    private String customerContactNo;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] customerImage;
    @Column(nullable = false)
    private String customerRemarks;

    @JsonIgnore
    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(mappedBy = "customer")
    private List<Booking> bookingList;
}
