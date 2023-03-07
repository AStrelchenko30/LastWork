package ru.skypro.homework.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.CommentsDto;
import ru.skypro.homework.dto.CreateAds;
import ru.skypro.homework.entity.Ads;
import ru.skypro.homework.repository.AdsRepository;
import ru.skypro.homework.repository.CommentRepository;
import ru.skypro.homework.repository.ImageRepository;
import ru.skypro.homework.repository.UserProfileRepository;
import ru.skypro.homework.service.AdsService;

import javax.xml.stream.events.Comment;
import java.util.Collection;

public class AdsServiceImpl implements AdsService {


    private final CommentRepository commentRepository;
    private final AdsRepository adsRepository;
    private final UserProfileRepository userProfileRepository;
    private final ImageRepository imageRepository;


    public AdsServiceImpl(CommentRepository commentRepository, AdsRepository adsRepository, UserProfileRepository userProfileRepository, ImageRepository imageRepository) {
        this.commentRepository = commentRepository;
        this.adsRepository = adsRepository;
        this.userProfileRepository = userProfileRepository;
        this.imageRepository = imageRepository;
    }

    @Override
    public ResponseEntity<?> getAllAds() {
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> createAds(CreateAds ads, MultipartFile image) {
        return null;
    }

    @Override
    public ResponseEntity<?> getComments(String adPk) {
        return null;
    }

    @Override
    public ResponseEntity<?> addAdsComment(String adPk, CommentsDto comment) {
        return null;
    }

    @Override
    public ResponseEntity<?> getFullAds(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<?> removeAds(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<?> updateAds(Integer Id, CreateAds createAds) {
        return null;
    }

    @Override
    public ResponseEntity<?> getAdsComment(String adPk, Integer Id) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteAdsComment(String adPk, Integer Id) {
        return null;
    }

    @Override
    public ResponseEntity<?> updateComment(String adPk, Integer Id, Comment comment) {
        return null;
    }

    @Override
    public ResponseEntity<?> getAdsMeUsingGET() {
        return null;
    }
}
