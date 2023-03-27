package ru.skypro.homework.entity;

import org.hibernate.Hibernate;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Objects;


@Entity

public class Avatar {
    @OneToOne
    private UserProfile userProfile;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Lob
    @Column(name = "data")
    @Type(type = "org.hibernate.type.BinaryType")
    private byte[] image;

    public Avatar() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Avatar avatar = (Avatar) o;
        return id != null && Objects.equals(id, avatar.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public String getId() {
        return this.id;
    }

    public byte[] getImage() {
        return this.image;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String toString() {
        return "Avatar(id=" + this.getId() + ", image=" + java.util.Arrays.toString(this.getImage()) + ")";
    }
}
