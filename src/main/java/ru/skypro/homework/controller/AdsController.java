package ru.skypro.homework.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.*;
import ru.skypro.homework.entity.Comment;
import ru.skypro.homework.service.AdsService;
import ru.skypro.homework.service.impl.ImageServiceImpl;


@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequestMapping("/ads")
@RequiredArgsConstructor

public class AdsController {

    private final AdsService adsService;

    private final ImageServiceImpl imageService;


    @GetMapping
    public ResponseEntity<?> getAllAds() {
        return ResponseEntity.ok(adsService.getAllAds());
    }

    @ApiOperation(value = "addAds")
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> createAds(@RequestPart("properties") CreateAds ads, @RequestPart("image") MultipartFile image) {
        return ResponseEntity.ok(adsService.createAds(ads, image));
    }

    @ApiOperation(value = "getComments")
    @GetMapping("/{ad_pk}/comments")
    public ResponseEntity<?> getComments(@PathVariable(value = "ad_pk") String adPk) {
        return ResponseEntity.ok(adsService.getComments(adPk));
    }

    @ApiOperation(value = "addComments")
    @PostMapping("/{ad_pk}/comments")
    public ResponseEntity<CommentsDto> addAdsComment(@PathVariable(value = "ad_pk") Long adPk,
                                                     @RequestBody CommentsDto comment) {
        return ResponseEntity.ok(adsService.addAdsComment(adPk, comment));
    }

    @ApiOperation(value = "getFullAd")
    @GetMapping("/{id}")
    public ResponseEntity<FullAds> getFullAds(@PathVariable Integer id) {
        return ResponseEntity.ok(adsService.getFullAds(id));
    }

    @ApiOperation(value = "removeAds")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeAds(@PathVariable Integer id) {
        return ResponseEntity.ok(adsService.removeAds(id));
    }

    @ApiOperation(value = "updateAds")
    @PatchMapping("/{id}")
    public ResponseEntity<AdsDto> updateAds(@PathVariable(value = "id") Integer Id,
                                            @RequestBody CreateAds createAds) {
        return ResponseEntity.ok(adsService.updateAds(Id, createAds));

    }

    @ApiOperation(value = "getComments")
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{ad_pk}/comments/{id}")
    public ResponseEntity<CommentsDto> getAdsComment(@PathVariable(value = "ad_pk") String adPk,
                                                     @PathVariable(value = "id") Integer Id) {
      return ResponseEntity.ok(adsService.getAdsComment(adPk, Id));

    }

    @ApiOperation(value = "deleteComments")
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{ad_pk}/comments/{id}")
    public ResponseEntity<CommentsDto> deleteAdsComment(@PathVariable(value = "ad_pk") String adPk,
                                                        @PathVariable(value = "id") Integer Id) {
        return ResponseEntity.ok(adsService.deleteAdsComment(adPk, Id));
    }

    @ApiOperation(value = "updateComments")
    @PatchMapping("/{ad_pk}/comments/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable(value = "ad_pk") String adPk,
                                                 @PathVariable(value = "id") Integer Id,
                                                 @RequestBody Comment comment
    ) {
        return ResponseEntity.ok(adsService.updateComment(adPk, Id, comment));
    }


    @ApiOperation(value = "getAdsMe")
    @GetMapping("/me")
    public ResponseEntity<ResponseWrapperAds> getAdsMeUsingGET() {
        return ResponseEntity.ok().build();
    }
}