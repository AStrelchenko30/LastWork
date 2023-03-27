package ru.skypro.homework.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.*;
import ru.skypro.homework.entity.Ads;
import ru.skypro.homework.entity.Comment;

import java.util.List;


public interface AdsService {

    ResponseWrapperAds getAllAds();


    AdsDto createAds(CreateAds ads, MultipartFile image);

    ResponseWrapperComment getComments(String adPk);

    CommentsDto addAdsComment(Long adPk, CommentsDto comment);

    FullAds getFullAds(Integer id);

    AdsDto removeAds(Integer id);

    AdsDto updateAds(Integer Id, CreateAds createAds);

    CommentsDto getAdsComment(String adPk, Integer Id);

    CommentsDto deleteAdsComment(String adPk, Integer Id);

    Comment updateComment(String adPk, Integer Id, Comment comment);

    List<Ads> getAdsMeUsingGET(UserDetails userDetails);

    List<Ads> findAdsByTitle(String title);


}
