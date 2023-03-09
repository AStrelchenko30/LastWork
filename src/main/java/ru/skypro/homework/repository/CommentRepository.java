package ru.skypro.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.skypro.homework.entity.Comment;

import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    void deleteByAdsId(Long adsId, Long commentId);

    @Query(value = "select ac from Comment as ac where ac.id = :id and ac.pk.pk = :pk")
    Optional<Comment> findAdsCommentByPkAndId(String pk, Integer id);

}
