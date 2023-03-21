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
import ru.skypro.homework.exceptions.ForbiddenException;
import ru.skypro.homework.exceptions.UserNotFoundException;
import ru.skypro.homework.mappers.AdsMapper;
import ru.skypro.homework.mappers.CommentMapper;
import ru.skypro.homework.repository.AdsRepository;
import ru.skypro.homework.repository.CommentRepository;
import ru.skypro.homework.repository.UserProfileRepository;
import ru.skypro.homework.security.UtilWebSecurity;
import ru.skypro.homework.service.AdsService;


import java.time.LocalDateTime;
import java.util.*;

@Service
public class AdsServiceImpl implements AdsService, UtilWebSecurity {

    private final CommentRepository commentRepository;

    private final AdsMapper adsMapper;
    private final AdsRepository adsRepository;
    private final UserProfileRepository userProfileRepository;

    private final CommentMapper commentMapper;


    public AdsServiceImpl(CommentRepository commentRepository, AdsMapper adsMapper, AdsRepository adsRepository, UserProfileRepository userProfileRepository, CommentMapper commentMapper) {
        this.commentRepository = commentRepository;
        this.adsMapper = adsMapper;
        this.adsRepository = adsRepository;
        this.userProfileRepository = userProfileRepository;
        this.commentMapper = commentMapper;
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
        Ads ads = adsRepository.findById(id).orElseThrow(AdsNotFoundException::new);

        if (Objects.equals(ads.getAuthor().getId(), getUser().getId()) || getUser().getRoleEnum() == Role.ADMIN) {
            adsRepository.deleteById(id);

            return adsMapper.dtoToAdsDto(ads);
        }
         throw new ForbiddenException();
    }

    @Override
    public Comment updateComment(String adPk, Integer Id, Comment comment) {
        Comment adsComment = commentRepository.findAdsCommentByCreatedAtAndId(adPk, Id)
                .orElseThrow(CommentNotFoundException::new);
        if (Objects.equals(adsComment.getAuthor(), getUser().getId()) || getUser().getRoleEnum() == Role.ADMIN) {
            adsComment.setCreatedAt(LocalDateTime.now());
            commentRepository.save(adsComment);
            return comment;
        }
        throw new ForbiddenException();
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
        fullAds.setEmail(user.getEmail());//fullAds.setImage(ads.getImage());
        fullAds.setPhone(user.getPhone());
        fullAds.setPrice(ads.getPrice());
        fullAds.setTitle(ads.getTitle());
        return fullAds;
    }

    @Override
    public CommentsDto deleteAdsComment(String adPk, Integer Id) {
        Comment adsComment = commentRepository.findAdsCommentByCreatedAtAndId(adPk, Id)
                .orElseThrow(CommentNotFoundException::new);
        if (Objects.equals(adsComment.getAuthor(), getUser().getId() ) || getUser().getRoleEnum() == Role.ADMIN) {
            commentRepository.deleteById(Math.toIntExact(adsComment.getId()));
            return commentMapper.dtoToCommentsDto(adsComment);
        }
        throw new ForbiddenException();
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
