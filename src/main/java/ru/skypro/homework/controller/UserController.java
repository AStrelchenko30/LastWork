package ru.skypro.homework.controller;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.NewPassword;
import ru.skypro.homework.dto.UserDto;
import ru.skypro.homework.entity.UserProfile;
import ru.skypro.homework.repository.AvatarRepository;
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
    private final AvatarRepository avatarRepository;

    public UserController(UserProfileService userProfileService, ImageService imageService, AuthService authService, AvatarRepository avatarRepository) {
        this.userProfileService = userProfileService;
        this.imageService = imageService;
        this.authService = authService;
        this.avatarRepository = avatarRepository;
    }

    @Operation(summary = "setPassword")
    @PostMapping("/set_password")
    ResponseEntity<NewPassword> changePassword(Authentication authentication, @RequestBody NewPassword newPassword) {
        if (authService.changePassword(authentication.getName(), newPassword)) {
            return ResponseEntity.ok(newPassword);
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

    @Operation(summary = "getUser")
    @GetMapping("/me")
    public ResponseEntity<UserDto> getUser(Authentication authentication) {
        return ResponseEntity.ok(userProfileService.findUser(authentication));
    }

    @Operation(summary= "updateUser")
    @PatchMapping(value = "/me")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userProfile, Authentication authentication) {
        return ResponseEntity.ok(userProfileService.updateUser(userProfile,authentication));
    }

    @PostMapping(value = "/avatar/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Long> saveAvatarImage(@RequestParam MultipartFile image,@PathVariable (value = "id") Long id ){
       return ResponseEntity.ok(userProfileService.updateUserAvatar(image, id));
    }
}


