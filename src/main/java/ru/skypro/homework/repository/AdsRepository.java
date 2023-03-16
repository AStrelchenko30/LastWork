package ru.skypro.homework.repository;

import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.skypro.homework.entity.Ads;

import javax.inject.Qualifier;
import java.util.Collection;


@Repository
public interface AdsRepository extends JpaRepository<Ads, Integer> {


    void deleteAllById(Long adsId);

//    @Query(value = "select * from advert where lower(title) like lower(concat('%', ?1,'%'))", nativeQuery = true)
    Collection<Ads> findAllByTitle(String title);
}
