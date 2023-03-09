package ru.skypro.homework.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.NewPassword;
import ru.skypro.homework.dto.UserDto;
import ru.skypro.homework.entity.Image;
import ru.skypro.homework.entity.UserProfile;
import ru.skypro.homework.mappers.ImageMapper;
import ru.skypro.homework.mappers.UserMapper;
import ru.skypro.homework.service.ImageService;
import ru.skypro.homework.service.UserProfileService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserProfileService userProfileService;
    private final ImageService imageService;

    public UserController(UserProfileService userProfileService, ImageService imageService) {
        this.userProfileService = userProfileService;
        this.imageService = imageService;
    }

    @ApiOperation(value = "setPassword")
    @PostMapping("/set_password")
    ResponseEntity<NewPassword> changePassword(@RequestBody NewPassword newPassword) {
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "getUser")
    @GetMapping("/me")
    public UserDto getUser(Long id) {
        UserProfile userProfileGet = userProfileService.findUser(id);
        return UserMapper.INSTANCE.dtoToUserDto(userProfileGet);
    }

    @ApiOperation(value = "updateUser")
    @PatchMapping("/me")
    public UserDto updateUser(@RequestBody UserProfile userProfile) {
        UserProfile userProfileUpdate = userProfileService.updateUser(userProfile);
        return UserMapper.INSTANCE.dtoToUserDto(userProfileUpdate);
    }

/*
    @ApiOperation(value = "updateUserImage", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @PatchMapping("/me/image")
    public ResponseEntity<UserDto> updateUserImage(@RequestPart MultipartFile image) {
        UserDto userProfileImage = imageService.updateImage(image);
        ImageMapper.INSTANCE.dtoToImage(userProfileImage);
        return ResponseEntity.ok().build();
    }
 */

}


