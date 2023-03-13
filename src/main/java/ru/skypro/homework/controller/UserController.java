package ru.skypro.homework.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.NewPassword;
import ru.skypro.homework.dto.UserDto;
import ru.skypro.homework.entity.UserProfile;
import ru.skypro.homework.service.AuthService;
import ru.skypro.homework.service.ImageService;
import ru.skypro.homework.service.UserProfileService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserProfileService userProfileService;
    private final ImageService imageService;
    private final AuthService authService;

    public UserController(UserProfileService userProfileService, ImageService imageService, AuthService authService) {
        this.userProfileService = userProfileService;
        this.imageService = imageService;
        this.authService=authService;
    }

    @ApiOperation(value = "setPassword")
    @PostMapping("/set_password")
    ResponseEntity<NewPassword> changePassword(Authentication authentication, @RequestBody NewPassword newPassword) {
        if (authService.changePassword(authentication.getName(), newPassword)) {
            return ResponseEntity.ok(newPassword);
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }
    @ApiOperation(value = "getUser")
    @GetMapping("/me")
    public ResponseEntity<UserDto> getUser(Long id) {
        return ResponseEntity.ok(userProfileService.findUser(id));
    }

    @ApiOperation(value = "updateUser")
    @PatchMapping("/me")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserProfile userProfile) {
        return ResponseEntity.ok(userProfileService.updateUser(userProfile));
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


