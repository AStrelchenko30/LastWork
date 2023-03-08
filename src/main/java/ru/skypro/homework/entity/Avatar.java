package ru.skypro.homework.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
public class Avatar {
    @Id
    @GeneratedValue
    private Long id;

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
}
