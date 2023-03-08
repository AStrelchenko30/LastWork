package ru.skypro.homework.service;

import ru.skypro.homework.entity.UserProfile;

public interface UserProfileService {
    public UserProfile createUser(UserProfile userProfile);
    public UserProfile updateUser(UserProfile userProfileNew);
    public UserProfile findUser(Long id);
    public UserProfile deleteUser(Long id);

}
