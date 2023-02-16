package ru.skypro.homework.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.NewPassword;
import ru.skypro.homework.dto.UserDto;

@RestController
@RequestMapping("/users/me")
@CrossOrigin(value = "http://localhost:3000")
public class UserController {

    @PatchMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody UserDto userDto) {
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/set_password")
    public ResponseEntity<?> setPassword(@RequestBody NewPassword newPassword) {
        return ResponseEntity.ok().build();
    }


    @GetMapping("/get")
    public ResponseEntity<?> getUser(@RequestBody UserDto user) {
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/me/image")
    public ResponseEntity<?> updateUserImage(@RequestBody UserDto user) {
        return ResponseEntity.ok().build();
    }

}
