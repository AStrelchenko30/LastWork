package ru.skypro.homework.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
//@Table(name = "users_profiles")
public class UserProfile {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  //  @Column(name = "id")
    private Long id;

   // @Column(name = "email")
    private String email;

  //  @Column(name = "first_name")
    private String firstName;

  //  @Column(name = "last_name")
    private String lastName;

   // @Column(name = "phone")
    private String phone;

    @OneToMany(mappedBy="author")
    private Set<Ads> ads;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<Ads> getAds() {
        return ads;
    }

    public void setAds(Set<Ads> ads) {
        this.ads = ads;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", ads=" + ads +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserProfile that = (UserProfile) o;
        return id.equals(that.id) && email.equals(that.email) && firstName.equals(that.firstName) && lastName.equals(that.lastName) && phone.equals(that.phone) && ads.equals(that.ads);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, firstName, lastName, phone, ads);
    }
}
