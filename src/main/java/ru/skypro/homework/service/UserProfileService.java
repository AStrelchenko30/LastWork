package ru.skypro.homework.service;

import ru.skypro.homework.dto.UserDto;
import ru.skypro.homework.entity.UserProfile;

import java.util.List;

public interface UserProfileService {
    public UserProfile createUser(UserProfile userProfile);
    public UserDto updateUser(UserProfile userProfileNew);
    public UserDto findUser(Long id);
    public UserProfile deleteUser(Long id);
    public List<UserProfile> getAllUser();
}
