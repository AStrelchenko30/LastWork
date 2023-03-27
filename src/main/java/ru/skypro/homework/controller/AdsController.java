package ru.skypro.homework.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.*;
import ru.skypro.homework.entity.Comment;
import ru.skypro.homework.service.AdsService;
import ru.skypro.homework.service.ImageService;



@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequestMapping("/ads")
@RequiredArgsConstructor

public class AdsController {

    private final AdsService adsService;
    private final ImageService imageService;

    @GetMapping
    public ResponseEntity<?> getAllAds() {
        return ResponseEntity.ok(adsService.getAllAds());
    }

    @Operation(summary = "addAds")
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> createAds(@RequestPart("properties") CreateAds ads, @RequestPart("image") MultipartFile image) {
        return ResponseEntity.ok(adsService.createAds(ads, image));
    }

    @Operation(summary = "getComments")
    @GetMapping("/{ad_pk}/comments")
    public ResponseEntity<?> getComments(@PathVariable(value = "ad_pk") Long adPk) {
        return ResponseEntity.ok(adsService.getComments(adPk));
    }

    @Operation(summary = "addComments")
    @PostMapping("/{ad_pk}/comments")
    public ResponseEntity<CommentsDto> addAdsComment(@PathVariable(value = "ad_pk") Long adPk,
                                                     @RequestBody CommentsDto comment, Authentication authentication) {
        return ResponseEntity.ok(adsService.addAdsComment(adPk, comment,authentication));
    }

    @Operation(summary = "getFullAd")
    @GetMapping("/{id}")
    public ResponseEntity<FullAds> getFullAds(@PathVariable Long id,Authentication authentication) {
        return ResponseEntity.ok(adsService.getFullAds(id,authentication));
    }

    @Operation(summary = "removeAds")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeAds(@PathVariable Long id) {
        return ResponseEntity.ok(adsService.removeAds(id));
    }

    @Operation(summary = "updateAds")
    @PatchMapping("/{id}")
    public ResponseEntity<AdsDto> updateAds(@PathVariable(value = "id") Long Id,
                                            @RequestBody CreateAds createAds) {
        return ResponseEntity.ok(adsService.updateAds(Id, createAds));

    }

    @Operation(summary = "getComments")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @GetMapping("/{ad_pk}/comments/{id}")
    public ResponseEntity<CommentsDto> getAdsComment(@PathVariable(value = "ad_pk") Long adPk,
                                                     @PathVariable(value = "id") Long Id) {
        return ResponseEntity.ok(adsService.getAdsComment(adPk, Id));

    }

    @Operation(summary = "deleteComments")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @DeleteMapping("/{ad_pk}/comments/{id}")
    public ResponseEntity<CommentsDto> deleteAdsComment(@PathVariable(value = "ad_pk") Long adPk,
                                                        @PathVariable(value = "id") Long Id) {
        return ResponseEntity.ok(adsService.deleteAdsComment(adPk, Id));
    }

    @Operation(summary = "updateComments")
    @PatchMapping("/{ad_pk}/comments/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable(value = "ad_pk") Long adPk,
                                                 @PathVariable(value = "id") Long Id,
                                                 @RequestBody Comment comment
    ) {
        return ResponseEntity.ok(adsService.updateComment(adPk, Id, comment));
    }


    @Operation(summary = "getAdsMe")
    @GetMapping("/me")
    public ResponseWrapperAds getAdsMeUsingGET(Authentication authentication) {
        return adsService.getAdsMeUsingGET(authentication);
    }

    @Operation(summary = "updateAdsImage")
    @PatchMapping(value = "/image/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Long> updateAdsImage(@RequestParam MultipartFile image, @PathVariable (value = "id") Long id) {
        return ResponseEntity.ok(imageService.updateAdsImage(image,id));
    }

}