package ru.skypro.homework.service.impl;


import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;
import org.webjars.NotFoundException;
import ru.skypro.homework.dto.UserDto;
import ru.skypro.homework.entity.Ads;
import ru.skypro.homework.entity.Avatar;
import ru.skypro.homework.entity.Image;
import ru.skypro.homework.entity.UserProfile;
import ru.skypro.homework.mappers.UserMapper;

import ru.skypro.homework.repository.AvatarRepository;
import ru.skypro.homework.repository.UserProfileRepository;
import ru.skypro.homework.service.UserProfileService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
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
    public UserDto updateUser(UserDto userProfileNew, Authentication authentication) {
        Optional<UserProfile> userProfileOld=userProfileRepository.findByEmail(authentication.getName());
        if (userProfileOld.isPresent()) {
            userProfileOld.get().setFirstName(userProfileNew.getFirstName());
            userProfileOld.get().setPhone(userProfileNew.getPhone());
            userProfileOld.get().setLastName(userProfileNew.getLastName());
            return UserMapper.INSTANCE.dtoToUserDto(userProfileRepository.save(userProfileOld.get()));
        }
         throw new NotFoundException("User not found");
    }

    @Override
    public UserDto findUser(Authentication authentication) {
        Optional<UserProfile> userByEmail= userProfileRepository.findByEmail(authentication.getName());
        if(userByEmail.isPresent()){
            return UserMapper.INSTANCE.dtoToUserDto(userByEmail.get());
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
    public Long updateUserAvatar(MultipartFile image,Long id) throws RuntimeException {

        Avatar entity = new Avatar();
        try {
            byte[] bytes = image.getBytes();
            entity.setImage(bytes);
            Avatar avatar = avatarRepository.findAvatarById(id);
            avatar.setImage(bytes);
            avatarRepository.save(avatar);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Avatar savedEntity = avatarRepository.saveAndFlush(entity);
        return savedEntity.getId();
    }


      /*  Avatar entity = new Avatar();
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

       */
}
