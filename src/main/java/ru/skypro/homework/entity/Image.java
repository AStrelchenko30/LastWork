package ru.skypro.homework.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name="image")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "file_size")
    private long fileSize;
    @Column(name = "media_type")
    private String mediaType;

    @Lob
    @Column(name = "data")
    @Type(type="org.hibernate.type.BinaryType")
    private byte[] data;

    public Image() {
    }

    @OneToOne(mappedBy = "image")
    private Ads ads;

    public Image(Long id, long fileSize, String mediaType, byte[] data, Ads ads) {
        this.id = id;
        this.fileSize = fileSize;
        this.mediaType = mediaType;
        this.data = data;
        this.ads = ads;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", fileSize=" + fileSize +
                ", mediaType='" + mediaType + '\'' +
                ", data=" + Arrays.toString(data) +
                ", ads=" + ads +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public Ads getAds() {
        return ads;
    }

    public void setAds(Ads ads) {
        this.ads = ads;
    }
}
