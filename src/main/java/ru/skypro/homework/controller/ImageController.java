package ru.skypro.homework.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/image")
@CrossOrigin(value = "http://localhost:3000")
public class ImageController {

    @PostMapping("/{id}")
    public ResponseEntity<?> updateAdsImage (@PathVariable Integer id) {
        return ResponseEntity.ok().build();
    }


}
