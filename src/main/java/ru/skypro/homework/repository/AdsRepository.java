package ru.skypro.homework.repository;

import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.skypro.homework.entity.Ads;

import java.util.Collection;


@Repository
public interface AdsRepository extends JpaRepository<Ads, Integer> {

    void deleteAllById(Long adsId);

    Collection<Ads> findAllByTitle(String title);
}
