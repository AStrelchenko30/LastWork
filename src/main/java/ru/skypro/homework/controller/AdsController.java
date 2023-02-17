package ru.skypro.homework.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.*;

import javax.persistence.criteria.CriteriaBuilder;

@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequestMapping("/ads")
public class AdsController {

    @GetMapping
    public ResponseEntity<?> getAllAds(@RequestParam(required = false) String title) {
        return ResponseEntity.ok().build();
    }

    @PostMapping()
    public ResponseEntity<?> createAds(@RequestPart("properties") CreateAds ads, @RequestPart("image") MultipartFile photo) {
        return ResponseEntity.ok().build();
    }
    @GetMapping("/{ad_pk}/comments")
    public ResponseEntity<?> getComments(@PathVariable(value = "ad_pk") String adPk) {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{ad_pk}/comments")
    public ResponseEntity<?> addAdsComment(@PathVariable(value = "ad_pk") String adPk,
                                           @RequestBody CommentsDto comment) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
   public ResponseEntity<?> getFullAds(@PathVariable Integer id) {
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateAds(@PathVariable Integer id,
                                     @RequestBody CreateAds createAds) {
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> removeAds(@PathVariable Integer id) {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{ad_pk}/comments/{id}")
    public ResponseEntity<?> getAdsComment(@PathVariable(value = "ad_pk") String adPk,
                                             @PathVariable(value = "id") Integer Id) {
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{ad_pk}/comments/{id}")
    public ResponseEntity<?> deleteAdsComment(@PathVariable(value = "ad_pk") String adPk,
                                       @PathVariable(value = "id") Integer Id) {
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{ad_pk}/comments/{id}")
    public ResponseEntity<?> updateComment(@PathVariable(value = "ad_pk") String adPk,
                                                @PathVariable(value = "id") Integer Id
                                                //@RequestBody Comment comment,
    ) {
        return ResponseEntity.ok().build();
    }




}