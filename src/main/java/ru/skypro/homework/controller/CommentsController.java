package ru.skypro.homework.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.AdsDto;
import ru.skypro.homework.dto.CommentsDto;
import ru.skypro.homework.dto.ResponseWrapperComment;

@RestController
@CrossOrigin(value = "http://localhost:3000")
@RequestMapping("/ads/{adPk}/comments")
public class CommentsController {

    @PostMapping("/update/{id}")
    public ResponseEntity<?> updateComments (@PathVariable String adPk, @PathVariable Integer id, @RequestBody CommentsDto dto) {
        return ResponseEntity.ok().build();
    }


    @PostMapping("/get")
    public ResponseEntity<?> getComments(@PathVariable String adPk, @RequestBody ResponseWrapperComment comment) {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/post")
    public ResponseEntity<?> addComments (@PathVariable String adPk, @RequestBody CommentsDto commentsDto) {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/get/{id}")
    public ResponseEntity<?> getComments(@PathVariable String adPk, @PathVariable Integer id) {
        return ResponseEntity.ok().build();
    }



    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deleteComments (@PathVariable String adPk, @PathVariable Integer id) {
        return ResponseEntity.ok().build();
    }



}
