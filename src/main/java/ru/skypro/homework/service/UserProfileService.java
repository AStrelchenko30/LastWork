package ru.skypro.homework.service;

import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.UserDto;
import ru.skypro.homework.entity.UserProfile;

import java.util.List;

public interface UserProfileService {
    public UserProfile createUser(UserProfile userProfile);

    public UserDto updateUser(UserDto userProfileNew, Authentication authentication);

    public UserDto findUser(Authentication authentication) ;

    public UserProfile deleteUser(Long id);

    public List<UserProfile> getAllUser();

    Long updateUserAvatar(MultipartFile image, Long id) throws RuntimeException;
}
