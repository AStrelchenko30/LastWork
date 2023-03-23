package ru.skypro.homework.service.impl;


import org.webjars.NotFoundException;
import ru.skypro.homework.dto.UserDto;
import ru.skypro.homework.entity.UserProfile;
import ru.skypro.homework.mappers.UserMapper;

import ru.skypro.homework.repository.UserProfileRepository;
import ru.skypro.homework.service.UserProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository userProfileRepository;

    public UserProfileServiceImpl(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;

    }

    @Override
    public UserProfile createUser(UserProfile userProfile) {
        if (!userProfileRepository.findAll().contains(userProfile)) {
            userProfileRepository.save(userProfile);
        }
        throw new NotFoundException("User already exist");
    }

    @Override
    public UserDto updateUser(UserProfile userProfileNew) {
        if (userProfileRepository.findById(userProfileNew.getId()).isPresent()) {
            UserProfile userProfileOld = userProfileRepository.findById(userProfileNew.getId()).get();
            userProfileOld.setEmail(userProfileNew.getEmail());
            userProfileOld.setFirstName(userProfileNew.getFirstName());
            userProfileOld.setLastName(userProfileNew.getLastName());
            userProfileOld.setPhone(userProfileNew.getPhone());
            userProfileOld.setAds(userProfileNew.getAds());
            userProfileRepository.save(userProfileOld);
            return UserMapper.INSTANCE.dtoToUserDto(userProfileNew);
        } else if (userProfileRepository.findById(userProfileNew.getId()).isEmpty()) {
           userProfileRepository.save(userProfileNew);
        } return UserMapper.INSTANCE.dtoToUserDto(userProfileNew);
        //        throw new NotFoundException("User not found");
    }

    @Override
    public UserDto findUser(Long id) {
        if (userProfileRepository.findById(id).isPresent()) {
            return UserMapper.INSTANCE.dtoToUserDto(userProfileRepository.findById(id).get());
        }
        throw new NotFoundException("User not found");
    }

    @Override
    public List<UserProfile> getAllUser() {
        return userProfileRepository.findAll();
    }

    @Override
    public UserProfile deleteUser(Long id) {
        if (userProfileRepository.findById(id).isPresent()) {
            userProfileRepository.deleteById(id);
        }
        throw new NotFoundException("User not found");
    }


}
