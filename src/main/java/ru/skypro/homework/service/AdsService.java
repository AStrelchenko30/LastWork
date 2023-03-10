package ru.skypro.homework.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.*;
import ru.skypro.homework.entity.Comment;


public interface AdsService {

    ResponseWrapperAds getAllAds();
    AdsDto createAds(CreateAds ads, MultipartFile image);
    ResponseWrapperComment getComments(String adPk);
    CommentsDto addAdsComment(Long adPk,CommentsDto comment);
    FullAds getFullAds(Integer id);
    AdsDto removeAds(Integer id);
    AdsDto updateAds(Integer Id,CreateAds createAds);
    CommentsDto getAdsComment(String adPk, Integer Id);
    CommentsDto deleteAdsComment(String adPk,Integer Id);
    Comment updateComment(String adPk, Integer Id, Comment comment);



    ResponseEntity<?> getAdsMeUsingGET();
}
