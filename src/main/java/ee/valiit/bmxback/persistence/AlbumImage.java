package ee.valiit.bmxback.persistence;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "album_image", schema = "bmx")
public class AlbumImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "album_id", nullable = false)
    private Album album;

    @NotNull
    @Column(name = "image_data", nullable = false)
    private byte[] imageData;

    @Size(max = 255)
    @Column(name = "photographer_name")
    private String photographerName;

    @Size(max = 255)
    @Column(name = "description")
    private String description;

}