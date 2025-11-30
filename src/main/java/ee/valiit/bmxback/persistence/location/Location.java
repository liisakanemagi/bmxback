package ee.valiit.bmxback.persistence.location;

import ee.valiit.bmxback.persistence.locationtype.LocationType;
import ee.valiit.bmxback.persistence.user.User;
import ee.valiit.bmxback.persistence.county.County;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "location", schema = "bmx")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "location_type_id", nullable = false)
    private LocationType locationType;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "county_id", nullable = false)
    private County county;

    @Size(max = 255)
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Size(max = 255)
    @Column(name = "address")
    private String address;

    @NotNull
    @Column(name = "lng", nullable = false, precision = 9, scale = 6)
    private BigDecimal lng;

    @NotNull
    @Column(name = "lat", nullable = false, precision = 9, scale = 6)
    private BigDecimal lat;

    @Size(max = 1000)
    @Column(name = "description", length = 1000)
    private String description;

    @Size(max = 3)
    @NotNull
    @Column(name = "status", nullable = false, length = 3)
    private String status;

    @NotNull
    @Column(name = "average_rating", nullable = false, precision = 2, scale = 1)
    private BigDecimal averageRating;

    @NotNull
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

}