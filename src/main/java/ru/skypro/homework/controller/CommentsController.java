package ru.skypro.homework.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.AdsDto;
import ru.skypro.homework.dto.CommentsDto;

@RestController
@CrossOrigin(value = "http://localhost:3000")
public class CommentsController {

    @PostMapping("/{ad_pk}/comments/{id}")
    public ResponseEntity<?> updateComments (@PathVariable String ad_pk, @PathVariable Integer id) {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{ad_pk}/comments")
    public ResponseEntity<?> getComments(@PathVariable String ad_pk) {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{ad_pk}/comments/{id}")
    public ResponseEntity<?> getCommentsId( @PathVariable String ad_pk, @PathVariable Integer id) {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{ad_pk}/comments/{id}")
    public ResponseEntity<?> deleteComments (@PathVariable String ad_pk, @PathVariable Integer id) {
        return ResponseEntity.ok().build();
    }



}
