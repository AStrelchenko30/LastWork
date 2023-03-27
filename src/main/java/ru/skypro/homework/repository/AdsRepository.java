package ru.skypro.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.skypro.homework.entity.Ads;
import java.util.List;

@Repository
public interface AdsRepository extends JpaRepository<Ads, Integer> {


    void deleteAllById(Long adsId);

    List<Ads> findAllByTitle(String title);

    List<Ads> findAdsByTitleLike(String title);

    List<Ads> findAdsByAuthor(String author);

    Ads findAdsById(Long id);
}
