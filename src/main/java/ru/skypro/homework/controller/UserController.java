package ru.skypro.homework.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.NewPassword;
import ru.skypro.homework.dto.UserDto;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/me")
    public ResponseEntity<UserDto> getUser(UserDto user) {

        return ResponseEntity.ok().build();
    }

    @PatchMapping("me")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto user) {
        return ResponseEntity.ok().build();
    }

    @PatchMapping("set_password")
    ResponseEntity<NewPassword> changePassword(@RequestBody NewPassword newPassword) {
            return ResponseEntity.ok().build();
        }
    }


