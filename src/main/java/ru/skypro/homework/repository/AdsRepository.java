package ru.skypro.homework.repository;

import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Repository;
import ru.skypro.homework.entity.Ads;
import ru.skypro.homework.entity.UserProfile;

import javax.inject.Qualifier;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


@Repository
public interface AdsRepository extends JpaRepository<Ads, Integer> {


    void deleteAllById(Long adsId);

    List<Ads> findAllByTitle(String title);
   List<Ads> findAdsByTitleLike(String title);
   List<Ads> findAdsByAuthor(String author);
}
