package ru.skypro.homework.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.AdsDto;
import ru.skypro.homework.dto.CommentsDto;
import ru.skypro.homework.dto.CreateAds;
import ru.skypro.homework.dto.ResponseWrapperAds;
import ru.skypro.homework.entity.Comment;


public interface AdsService {

    ResponseWrapperAds getAllAds();
    AdsDto createAds(CreateAds ads, MultipartFile image);
    ResponseEntity<?> getComments(String adPk);
    CommentsDto addAdsComment(String adPk,CommentsDto comment);
    ResponseEntity<?> getFullAds(Integer id);
    AdsDto removeAds(Integer id);
    AdsDto updateAds(Integer Id,CreateAds createAds);
    CommentsDto getAdsComment(String adPk, Integer Id);
    ResponseEntity<?> deleteAdsComment(String adPk,Integer Id);
    Comment updateComment(String adPk, Integer Id, Comment comment);



    ResponseEntity<?> getAdsMeUsingGET();
}
