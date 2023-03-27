package ru.skypro.homework.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
public class Ads {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_profile_id")
    private UserProfile author;

    private String title;

    private int price;

    private String description;


    @JoinColumn(name = "image_id", referencedColumnName = "id")
    private byte[] image;

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
