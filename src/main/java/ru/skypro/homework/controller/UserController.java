package ru.skypro.homework.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.CreateAds;
import ru.skypro.homework.dto.NewPassword;
import ru.skypro.homework.dto.UserDto;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/users")
public class UserController {

    @ApiOperation(value = "setPassword")
    @PostMapping("/set_password")
    ResponseEntity<NewPassword> changePassword(@RequestBody NewPassword newPassword) {
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "getUser")
    @GetMapping("/me")
    public ResponseEntity<UserDto> getUser(UserDto user) {
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "updateUser")
    @PatchMapping("/me")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto user) {
        return ResponseEntity.ok().build();
    }


    @ApiOperation(value = "updateUserImage", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @PatchMapping("/me/image")
    public ResponseEntity<UserDto> updateUserImage(@RequestPart MultipartFile image) {
        return ResponseEntity.ok().build();
    }
}


