package ru.skypro.homework.service;

import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.UserDto;
import ru.skypro.homework.entity.UserProfile;

import java.util.List;

public interface UserProfileService {
    public UserProfile createUser(UserProfile userProfile);

    public UserDto updateUser(UserProfile userProfileNew);

    public UserDto findUser(Long id);

    public UserProfile deleteUser(Long id);

    public List<UserProfile> getAllUser();

    String updateUserAvatar(MultipartFile image, Long id) throws RuntimeException;
}
