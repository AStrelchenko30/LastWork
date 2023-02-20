package ru.skypro.homework.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/image")
@CrossOrigin(value = "http://localhost:3000")
public class ImageController {

    @ApiOperation(value = "updateAdsImage")
    @PatchMapping("/{id}")
    public ResponseEntity<?> updateAdsImage(@PathVariable Integer id, @RequestBody MultipartFile photo) {
        return ResponseEntity.ok().build();
    }
}
