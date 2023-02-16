package ru.skypro.homework.controller;

import org.hibernate.annotations.Target;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.AdsDto;
import ru.skypro.homework.dto.CommentsDto;
import ru.skypro.homework.dto.CreateAds;
import ru.skypro.homework.dto.ResponseWrapperAds;

@RestController
@RequestMapping("/ads")
@CrossOrigin(value = "http://localhost:3000")
public class AdsController {

    @PostMapping("/post")
    public ResponseEntity<?> addAds(@RequestBody CreateAds req) {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/createAds/{id}")
    public ResponseEntity<?> updateAds(@RequestBody CreateAds req, @PathVariable Integer id) {
        return ResponseEntity.ok().build();
    }


    @PostMapping("/getALLAds")
    public ResponseEntity<?> getALLAds(@RequestBody ResponseWrapperAds req) {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/get/{id}")
    public ResponseEntity<?> getFullAd (@PathVariable Integer id) {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/removeAds/{id}")
    public ResponseEntity<?> removeAds (@PathVariable Integer id) {
        return ResponseEntity.ok().build();
    }


    // @PostMapping("/me")
    //public ResponseEntity<?> getAdsMeUsingGET (@Query boolean authenticated,) {
      //  return ResponseEntity.ok().build();
    //}
}
