package ru.skypro.homework.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long adsId;

    private Long author;

    private LocalDateTime createdAt;

    private String text;

    public Comment() {
    }

    public Comment(Long id, Long adsId, Long author, LocalDateTime createdAt, String text) {
        this.id = id;
        this.adsId = adsId;
        this.author = author;
        this.createdAt = createdAt;
        this.text = text;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", adsId=" + adsId +
                ", author=" + author +
                ", createdAt=" + createdAt +
                ", text='" + text + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAdsId() {
        return adsId;
    }

    public void setAdsId(Long adsId) {
        this.adsId = adsId;
    }

    public Long getAuthor() {
        return author;
    }

    public void setAuthor(Long author) {
        this.author = author;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return id.equals(comment.id) && adsId.equals(comment.adsId) && author.equals(comment.author) && createdAt.equals(comment.createdAt) && text.equals(comment.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, adsId, author, createdAt, text);
    }
}
