package ru.skypro.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.skypro.homework.entity.Comment;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    void deleteByAdsId(Long adsId, Long commentId);


    Optional<Comment> findAdsCommentByPkAndId(String pk, Integer id);


    List<Comment> findAdsCommentsByPk(String adPk);
}
