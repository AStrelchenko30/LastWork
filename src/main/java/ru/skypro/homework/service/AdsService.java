package ru.skypro.homework.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.CommentsDto;
import ru.skypro.homework.dto.CreateAds;

import javax.xml.stream.events.Comment;

public interface AdsService {

     ResponseEntity<?> getAllAds();
    CreateAds createAds(CreateAds ads, MultipartFile image);
    ResponseEntity<?> getComments(String adPk);
    ResponseEntity<?> addAdsComment(String adPk,CommentsDto comment);
    ResponseEntity<?> getFullAds(Integer id);
    ResponseEntity<?> removeAds(Integer id);
    ResponseEntity<?> updateAds(Integer Id,CreateAds createAds);
    ResponseEntity<?> getAdsComment(String adPk, Integer Id);
    ResponseEntity<?> deleteAdsComment(String adPk,Integer Id);
    ResponseEntity<?> updateComment(String adPk, Integer Id, Comment comment);
    ResponseEntity<?> getAdsMeUsingGET();
}
