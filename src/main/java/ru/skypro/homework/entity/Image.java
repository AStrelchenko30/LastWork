package ru.skypro.homework.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String id;

  //  @Column(name = "file_size")
    private long fileSize;
 //   @Column(name = "media_type")
    private String mediaType;

    @Lob
  //  @Column(name = "data")
    @Type(type = "org.hibernate.type.BinaryType")
    private byte[] data;

    public Image() {
    }

    @OneToOne(cascade = CascadeType.REFRESH)
    //@OneToOne(mappedBy = "image")
    private Ads ads;

    public Image(String id, long fileSize, String mediaType, byte[] data, Ads ads) {
        this.id = id;
        this.fileSize = fileSize;
        this.mediaType = mediaType;
        this.data = data;
        this.ads = ads;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image image = (Image) o;
        return fileSize == image.fileSize && id.equals(image.id) && mediaType.equals(image.mediaType) && Arrays.equals(data, image.data) && ads.equals(image.ads);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, fileSize, mediaType, ads);
        result = 31 * result + Arrays.hashCode(data);
        return result;
    }
}
