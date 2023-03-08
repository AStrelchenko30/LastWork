package ru.skypro.homework.service.impl;

import org.webjars.NotFoundException;
import ru.skypro.homework.entity.UserProfile;
import ru.skypro.homework.repository.UserProfileRepository;
import ru.skypro.homework.service.UserProfileService;
import org.springframework.stereotype.Service;

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
    public UserProfile updateUser(UserProfile userProfileNew) {
        if (userProfileRepository.findById(userProfileNew.getId()).isPresent()) {
            UserProfile userProfileOld = userProfileRepository.findById(userProfileNew.getId()).get();
            userProfileOld.setEmail(userProfileNew.getEmail());
            userProfileOld.setFirstName(userProfileNew.getFirstName());
            userProfileOld.setLastName(userProfileNew.getLastName());
            userProfileOld.setPhone(userProfileNew.getPhone());
            userProfileOld.setAds(userProfileNew.getAds());
            return userProfileRepository.save(userProfileOld);
        }
        throw new NotFoundException("User not found");
    }

    @Override
    public UserProfile findUser(Long id) {
        if (userProfileRepository.findById(id).isPresent()) {
            return userProfileRepository.findById(id).get();
        }
        throw new NotFoundException("User not found");
    }

    @Override
    public UserProfile deleteUser(Long id) {
        if (userProfileRepository.findById(id).isPresent()) {
            userProfileRepository.deleteById(id);
        }
        throw new NotFoundException("User not found");
    }

}
