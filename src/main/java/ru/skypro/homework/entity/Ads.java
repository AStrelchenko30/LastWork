package ru.skypro.homework.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
//@Table(name = "ads")

public class Ads {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_profile_id")
    private UserProfile author;

   // @Column(name = "title")
    private String title;

   // @Column(name = "price")
    private int price;

   // @Column(name = "description")

    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id", referencedColumnName = "id")
    private Image image;

    public Ads() {

    }

    public Ads(Integer id, UserProfile author, String title, int price, String description, Image image) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.price = price;
        this.description = description;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserProfile getAuthor() {
        return author;
    }

    public void setAuthor(UserProfile author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Ads{" +
                "id=" + id +
                ", author=" + author +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", image=" + image +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ads ads = (Ads) o;
        return price == ads.price && id.equals(ads.id) && author.equals(ads.author) && title.equals(ads.title) && description.equals(ads.description) && image.equals(ads.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, title, price, description, image);
    }
}
