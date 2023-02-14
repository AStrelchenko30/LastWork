package ru.skypro.homework.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/image")
public class ImageController {

    @PostMapping("/{id}")
    public ResponseEntity<?> updateAdsImage (@PathVariable Integer id) {
        return ResponseEntity.ok().build();
    }


}
