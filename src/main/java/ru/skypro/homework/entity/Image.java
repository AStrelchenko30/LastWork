package ru.skypro.homework.entity;

import org.hibernate.Hibernate;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    private byte[] data;

    public Image() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Image image = (Image) o;
        return id != null && Objects.equals(id, image.id);
          }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public Long getId() {
        return this.id;
    }

    public byte[] getImage() {
        return this.data;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setImage(byte[] data) {
        this.data = data;
    }

    public String toString() {
        return "AdsEntity(id=" + this.getId() + ", image=" + java.util.Arrays.toString(this.getImage()) + ")";
    }

}
