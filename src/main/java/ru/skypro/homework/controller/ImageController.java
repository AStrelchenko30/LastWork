package ru.skypro.homework.controller;

import io.swagger.annotations.ApiOperation;
import org.apache.catalina.authenticator.SavedRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.entity.Image;
import ru.skypro.homework.repository.ImageRepository;
import ru.skypro.homework.service.impl.ImageServiceImpl;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/image")
@CrossOrigin(value = "http://localhost:3000")
public class ImageController {


public final ImageServiceImpl service;

    public ImageController(ImageServiceImpl service) {
        this.service = service;
    }

    /* @ApiOperation(value = "updateAdsImage")
            @PostMapping (value = "/image/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
            public ResponseEntity<String> updateAdsImage(@PathVariable Integer id, @RequestParam MultipartFile image) {
                return ResponseEntity.ok().build();

            }*/
    @GetMapping(value = "/images/{id}", produces = {MediaType.IMAGE_PNG_VALUE})
    public byte[] getImage(@PathVariable("id") Long id) {
        return service.getPhoto(id);
    }


}
