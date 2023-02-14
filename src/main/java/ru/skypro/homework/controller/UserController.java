package ru.skypro.homework.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.UserDto;

@RestController
@RequestMapping("/users")
@CrossOrigin(value = "http://localhost:3000")
public class UserController {

    @PatchMapping("/me")
    public ResponseEntity <?> updateUser(@RequestBody UserDto user) {
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/me")
    public UserDto getUser(@RequestBody UserDto user) {
        return user;
    }

    @PatchMapping("/me/image")
    public ResponseEntity<?> updateUserImage(@RequestBody UserDto user) {
        return ResponseEntity.ok().build();
    }

}
