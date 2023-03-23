package ru.skypro.homework.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Setter
@Getter
@Entity
public class Avatar {
    @Id
    @GeneratedValue
    private String id;

    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    private byte[] data;
    //@OneToOne
    @ManyToOne(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
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
