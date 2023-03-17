package ru.skypro.homework.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.*;
import ru.skypro.homework.entity.Ads;
import ru.skypro.homework.entity.Comment;
import ru.skypro.homework.entity.UserProfile;
import ru.skypro.homework.exceptions.AdsNotFoundException;
import ru.skypro.homework.exceptions.CommentNotFoundException;
import ru.skypro.homework.exceptions.UserNotFoundException;
import ru.skypro.homework.mappers.AdsMapper;
import ru.skypro.homework.mappers.CommentMapper;
import ru.skypro.homework.repository.AdsRepository;
import ru.skypro.homework.repository.CommentRepository;
import ru.skypro.homework.repository.UserProfileRepository;
import ru.skypro.homework.service.AdsService;


import java.time.LocalDateTime;
import java.util.*;

@Service
public class AdsServiceImpl implements AdsService {

    private final CommentRepository commentRepository;
    private final AdsRepository adsRepository;
    private final UserProfileRepository userProfileRepository;


    public AdsServiceImpl(CommentRepository commentRepository, AdsRepository adsRepository, UserProfileRepository userProfileRepository) {
        this.commentRepository = commentRepository;
        this.adsRepository = adsRepository;
        this.userProfileRepository = userProfileRepository;
    }

    @Override
    public ResponseWrapperAds getAllAds() {
        ResponseWrapperAds responseWrapperAds = new ResponseWrapperAds();
        List<AdsDto> results = AdsMapper.INSTANCE.toDtoList(adsRepository.findAll());
        results.stream().sorted(Comparator.comparing(AdsDto::getAuthor));
        responseWrapperAds.setResults(results);
        responseWrapperAds.setCount(results.size());
        return responseWrapperAds;
    }

    @Override
    public AdsDto createAds(CreateAds ads, MultipartFile image) {
        Ads createAds = new Ads();
        createAds.setDescription(createAds.getDescription());
        createAds.setPrice(createAds.getPrice());
        adsRepository.save(createAds);
        return AdsMapper.INSTANCE.dtoToAdsDto(createAds);
    }

    @Override
    public CommentsDto getAdsComment(String adPk, Integer Id) {

        Comment adsComment = commentRepository.findAdsCommentByCreatedAtAndId(adPk, Id)
                .orElseThrow(CommentNotFoundException::new);
        return CommentMapper.INSTANCE.dtoToCommentsDto(adsComment);
    }

    @Override
    public AdsDto removeAds(Integer id) {
        Ads ads = adsRepository.findById(id).get();

        if (adsRepository.findById(id).isPresent()) {
            userProfileRepository.deleteById(id);
        }
        return AdsMapper.INSTANCE.dtoToAdsDto(ads);
    }

    @Override
    public Comment updateComment(String adPk, Integer Id, Comment comment) {
        Comment adsComment = commentRepository.findAdsCommentByCreatedAtAndId(adPk, Id)
                .orElseThrow(CommentNotFoundException::new);
        if (commentRepository.findById(Id).isPresent()) {
            //adsComment.setText(CommentsDto.getText()); ?????
            adsComment.setCreatedAt(LocalDateTime.now());
            commentRepository.save(adsComment);
            return comment;
        }
        throw new CommentNotFoundException();
    }

    @Override
    public AdsDto updateAds(Integer Id, CreateAds createAds) {
        Ads ads = adsRepository.findById(Id).orElseThrow(AdsNotFoundException::new);
        if (adsRepository.findById(Id).isPresent()) {
            ads.setDescription(createAds.getDescription());
            ads.setTitle(createAds.getTitle());
            ads.setPrice(createAds.getPrice());
            AdsDto adsDto = AdsMapper.INSTANCE.dtoToAdsDto(ads);
            adsDto.setPk(Id);
            adsRepository.save(ads);
            return adsDto;
        }
        throw new AdsNotFoundException();
    }

    @Override
    public ResponseWrapperComment getComments(String adPk) {
        List<Comment> adsCommentList = commentRepository.findAdsCommentByCreatedAt(adPk);
        List<CommentsDto> adsCommentDtoList = new ArrayList<>(adsCommentList.size());
        for (Comment adsComment : adsCommentList) {
            adsCommentDtoList.add(CommentMapper.INSTANCE.dtoToCommentsDto(adsComment));
        }
        ResponseWrapperComment responseWrapperComment = new ResponseWrapperComment();
        responseWrapperComment.setCount(adsCommentDtoList.size());
        responseWrapperComment.setResults(adsCommentDtoList);
        return responseWrapperComment;
    }

    @Override
    public CommentsDto addAdsComment(Long adPk, CommentsDto comment) {
        comment.setCreatedAt(String.valueOf(LocalDateTime.now()));
        comment.setPk(adPk);
        Comment adsComment = CommentMapper.INSTANCE.dtoToComments(comment);
        commentRepository.save(adsComment);
        return CommentMapper.INSTANCE.dtoToCommentsDto(adsComment);
    }

    @Override
    public FullAds getFullAds(Integer id) {
        Ads ads = adsRepository.findById(id).orElseThrow(AdsNotFoundException::new);
        UserProfile user = userProfileRepository.findById(Math.toIntExact(ads.getAuthor().getId())).orElseThrow(UserNotFoundException::new);
        FullAds fullAds = new FullAds();
        fullAds.setAuthorFirstName(user.getFirstName());
        fullAds.setAuthorLastName(user.getLastName());
        fullAds.setDescription(ads.getDescription());
        fullAds.setEmail(user.getEmail());
        fullAds.setImage(ads.getImage());
        fullAds.setPhone(user.getPhone());
        fullAds.setPrice(ads.getPrice());
        fullAds.setTitle(ads.getTitle());
        return fullAds;
    }

    @Override
    public CommentsDto deleteAdsComment(String adPk, Integer Id) {
        Comment adsComment = commentRepository.findAdsCommentByCreatedAtAndId(adPk, Id)
                .orElseThrow(CommentNotFoundException::new);
        if (commentRepository.findAdsCommentByCreatedAtAndId(adPk, Id).isPresent()) {
            commentRepository.deleteById(Math.toIntExact(adsComment.getId()));

            return CommentMapper.INSTANCE.dtoToCommentsDto(adsComment);
        }
        throw new RuntimeException("Comment not found");
    }

    @Override
    public ResponseEntity<?> getAdsMeUsingGET() {
        return null;
    }

    @Override
    public List<Ads> findAdsByTitle(String title){
        return adsRepository.findAdsByTitleLike(title);
    }
}
