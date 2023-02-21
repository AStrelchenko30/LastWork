package ru.skypro.homework.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.*;

import javax.xml.stream.events.Comment;


@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequestMapping("/ads")
public class AdsController {

    @GetMapping
    public ResponseEntity<?> getAllAds() {
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "addAds")
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> createAds(@RequestPart("properties") CreateAds ads, @RequestPart("image") MultipartFile image) {
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "getComments")
    @GetMapping("/{ad_pk}/comments")
    public ResponseEntity<?> getComments(@PathVariable(value = "ad_pk") String adPk) {
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "addComments")
    @PostMapping("/{ad_pk}/comments")
    public ResponseEntity<?> addAdsComment(@PathVariable(value = "ad_pk") String adPk,
                                           @RequestBody CommentsDto comment) {
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "getFullAd")
    @GetMapping("/{id}")
    public ResponseEntity<?> getFullAds(@PathVariable Integer id) {
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "removeAds")
    @DeleteMapping("/{id}")
    ResponseEntity<?> removeAds(@PathVariable Integer id) {
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "updateAds")
    @PatchMapping("/{id}")
    public ResponseEntity<?> updateAds(@PathVariable(value = "id") Integer Id,
                                       @RequestBody CreateAds createAds) {
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "getComments")
    @GetMapping("/{ad_pk}/comments/{id}")
    public ResponseEntity<?> getAdsComment(@PathVariable(value = "ad_pk") String adPk,
                                           @PathVariable(value = "id") Integer Id) {
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "deleteComments")
    @DeleteMapping("/{ad_pk}/comments/{id}")
    public ResponseEntity<?> deleteAdsComment(@PathVariable(value = "ad_pk") String adPk,
                                              @PathVariable(value = "id") Integer Id) {
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "updateComments")
    @PatchMapping("/{ad_pk}/comments/{id}")
    public ResponseEntity<?> updateComment(@PathVariable(value = "ad_pk") String adPk,
                                           @PathVariable(value = "id") Integer Id,
                                           @RequestBody Comment comment
    ) {
        return ResponseEntity.ok().build();
    }


    @ApiOperation(value = "getAdsMe")
    @GetMapping("/me")
    public ResponseEntity<?> getAdsMeUsingGET() {
        return ResponseEntity.ok().build();
    }
}