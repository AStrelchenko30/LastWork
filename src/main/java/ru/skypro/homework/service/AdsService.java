package ru.skypro.homework.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.*;
import ru.skypro.homework.entity.Ads;
import ru.skypro.homework.entity.Comment;

import java.util.List;


public interface AdsService {

    ResponseWrapperAds getAllAds();


    AdsDto createAds(CreateAds ads, MultipartFile image);

    ResponseWrapperComment getComments(Long adPk);

    CommentsDto addAdsComment(Long adPk, CommentsDto comment, Authentication authentication);

    FullAds getFullAds(Long id,Authentication authentication);

    AdsDto removeAds(Long id);

    AdsDto updateAds(Long Id, CreateAds createAds);

    CommentsDto getAdsComment(Long adPk, Long Id);

    CommentsDto deleteAdsComment(Long adPk, Long Id);

    Comment updateComment(Long adPk, Long Id, Comment comment);

    ResponseWrapperAds getAdsMeUsingGET(Authentication authentication);

    List<Ads> findAdsByTitle(String title);


}
