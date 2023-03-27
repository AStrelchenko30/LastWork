package ru.skypro.homework.entity;

import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    // private long fileSize;
    // private String mediaType;

    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    private byte[] data;

    public Image() {
    }

    @OneToOne(cascade = CascadeType.REFRESH)
    private Ads ads;

    /*  public Image(String id, long fileSize, String mediaType, byte[] data, Ads ads) {
        this.id = id;
        this.fileSize = fileSize;
        this.mediaType = mediaType;
        this.data = data;
        this.ads = ads;
    }
         */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Image image = (Image) o;
        return id != null && Objects.equals(id, image.id);
        // return fileSize == image.fileSize && id.equals(image.id) && mediaType.equals(image.mediaType) && Arrays.equals(data, image.data) && ads.equals(image.ads);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public String getId() {
        return this.id;
    }

    public byte[] getImage() {
        return this.data;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setImage(byte[] data) {
        this.data = data;
    }

    public String toString() {
        return "AdsEntity(id=" + this.getId() + ", image=" + java.util.Arrays.toString(this.getImage()) + ")";
    }

}
