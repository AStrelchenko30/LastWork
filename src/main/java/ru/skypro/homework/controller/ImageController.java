package ru.skypro.homework.controller;

import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.service.impl.ImageServiceImpl;

@RestController
@CrossOrigin(value = "http://localhost:3000")
public class ImageController {

    private final ImageServiceImpl service;

    public ImageController(ImageServiceImpl service) {
        this.service = service;
    }

    @GetMapping(value = "/image/{id}", produces = {MediaType.IMAGE_PNG_VALUE})
    public byte[] getImage(@PathVariable("id") Long id) {
        return service.getPhoto(id);
    }


    @GetMapping(value = "/avatar/")
    public byte[] getImageUser() {
        return service.getPhotoUser();
    }
}
