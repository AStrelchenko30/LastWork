package ru.skypro.homework.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.AdsDto;
import ru.skypro.homework.dto.CommentsDto;

@RestController
@RequestMapping("/ads")
public class AdsController {

    @PostMapping("/addAds")
    public ResponseEntity<?> addAds(@RequestBody AdsDto req) {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/createAds")
    public ResponseEntity<?> updateAds(@RequestBody AdsDto req) {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/allAds")
    public ResponseEntity<?> getALLAds(@RequestBody AdsDto req) {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> getFullAd (@PathVariable Integer id) {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> removeAds (@PathVariable Integer id) {
        return ResponseEntity.ok().build();
    }



}
