package ru.skypro.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.skypro.homework.entity.Comment;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    void deleteByAdsIdAndId(Long adsId, Long commentId);


    Optional<Comment> findByAdsIdAndId(Long pk, Long id);


    List<Comment> findByAdsId(Long adPk);
}
