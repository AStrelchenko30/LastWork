package ru.skypro.homework.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.NewPassword;
import ru.skypro.homework.dto.UserDto;
import ru.skypro.homework.entity.Image;
import ru.skypro.homework.entity.UserProfile;
import ru.skypro.homework.service.AuthService;
import ru.skypro.homework.service.ImageService;
import ru.skypro.homework.service.UserProfileService;
import ru.skypro.homework.service.impl.ImageServiceImpl;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/users")
public class UserController  {
    private final UserProfileService userProfileService;
    private final ImageServiceImpl imageService;
    private final AuthService authService;

    public UserController(UserProfileService userProfileService, ImageServiceImpl imageService, AuthService authService) {
        this.userProfileService = userProfileService;
        this.imageService = imageService;
        this.authService = authService;
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


   /*@ApiOperation(value = "updateUserImage", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @PatchMapping("/me/image")
    public ResponseEntity<Image> updateUserImage(@RequestPart Image image) {
               return ResponseEntity.ok(imageService.updateImage(image));
    }
*/
    @ApiOperation(value = "updateAdsImage")
    @PatchMapping(value = "/image/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> updateAdsImage(@PathVariable Integer id, @RequestParam MultipartFile image) {
        return ResponseEntity.ok().build();
    }
}


