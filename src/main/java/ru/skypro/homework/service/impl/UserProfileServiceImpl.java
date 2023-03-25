package ru.skypro.homework.service.impl;


import org.springframework.web.multipart.MultipartFile;
import org.webjars.NotFoundException;
import ru.skypro.homework.dto.UserDto;
import ru.skypro.homework.entity.Avatar;
import ru.skypro.homework.entity.UserProfile;
import ru.skypro.homework.mappers.UserMapper;

import ru.skypro.homework.repository.AvatarRepository;
import ru.skypro.homework.repository.UserProfileRepository;
import ru.skypro.homework.service.UserProfileService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository userProfileRepository;
    private final AvatarRepository avatarRepository;

    public UserProfileServiceImpl(UserProfileRepository userProfileRepository, AvatarRepository avatarRepository) {
        this.userProfileRepository = userProfileRepository;

        this.avatarRepository = avatarRepository;
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
        }
        return UserMapper.INSTANCE.dtoToUserDto(userProfileNew);
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

    @Override
    public String saveAvatar(MultipartFile image) throws RuntimeException {

        Avatar entity = new Avatar();
        try {
            byte[] bytes = image.getBytes();
            entity.setImage(bytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        entity.setId(UUID.randomUUID().toString());
        Avatar savedEntity = avatarRepository.saveAndFlush(entity);
        return savedEntity.getId();
    }
}
