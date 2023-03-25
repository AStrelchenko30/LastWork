package ru.skypro.homework.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Objects;


@Entity

public class Avatar {

 @Id
    private String id;
 @Lob
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
    }    public String toString() {
        return "Avatar(id=" + this.getId() + ", image=" + java.util.Arrays.toString(this.getImage()) + ")";
    }
 /*   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
private String filePath;
private long fileSize;

    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    private byte[] data;
    @OneToOne
    private UserProfile userProfile;

    public void setData(byte[] data) {
        this.data = data;
    }

    public byte[] getData() {
        return data;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

  */
}
