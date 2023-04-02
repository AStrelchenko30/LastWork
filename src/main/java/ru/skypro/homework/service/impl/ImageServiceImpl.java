package ru.skypro.homework.service.impl;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.webjars.NotFoundException;
import ru.skypro.homework.dto.AdsDto;
import ru.skypro.homework.dto.UserDto;
import ru.skypro.homework.entity.Ads;
import ru.skypro.homework.entity.Avatar;
import ru.skypro.homework.entity.Image;
import ru.skypro.homework.entity.UserProfile;
import ru.skypro.homework.mappers.AdsMapper;
import ru.skypro.homework.mappers.UserMapper;
import ru.skypro.homework.repository.AdsRepository;
import ru.skypro.homework.repository.AvatarRepository;
import ru.skypro.homework.repository.ImageRepository;
import ru.skypro.homework.repository.UserProfileRepository;
import ru.skypro.homework.service.ImageService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;
    private final AdsRepository adsRepository;
    private final AvatarRepository avatarRepository;
    private final UserProfileRepository userProfileRepository;

    public ImageServiceImpl(ImageRepository imageRepository, AdsRepository adsRepository, AvatarRepository avatarRepository, UserProfileRepository userProfileRepository) {
        this.imageRepository = imageRepository;
        this.adsRepository = adsRepository;
        this.avatarRepository = avatarRepository;
        this.userProfileRepository = userProfileRepository;
    }

    @Override
    public Image createImage(Image image) {
        if (!imageRepository.findAll().contains(image)) {
            imageRepository.save(image);
        }
        throw new NotFoundException("Image already exist");
    }

    @Override
    public Image findImage(Long id) {
        if (imageRepository.findById(id).isPresent()) {
            return imageRepository.findById(id).get();
        }
        throw new NotFoundException("Image not found");
    }

    @Override
    public Image deleteImage(Long id) {
        if (imageRepository.findById(id).isPresent()) {
            imageRepository.deleteById(id);
        }
        throw new NotFoundException("Image not found");
    }


    @Override
    public byte[] getPhoto(Long id) {
        Image image = imageRepository.getReferenceById(id);
        return image.getImage();
    }

    @Override
    public byte[] getPhotoUser(Long id) {
        Avatar avatar = avatarRepository.getReferenceById(id);
        return avatar.getImage();
    }


   /* @Override
    public byte[] getPhotoUser(Authentication authentication) {
        Optional<UserProfile> userProfile = userProfileRepository.findByEmail(authentication.getName());
        return userProfile.get().getAvatar().getImage();
    }

    */

    @Override
    public Long updateAdsImage(MultipartFile image, Long id) throws RuntimeException {
        Image entity = new Image();
        try {
            byte[] bytes = image.getBytes();
            entity.setImage(bytes);
            Ads ads = adsRepository.findAdsById(id);
            ads.setImage(entity);
            adsRepository.save(ads);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Image savedEntity = imageRepository.saveAndFlush(entity);
        return savedEntity.getId();
    }
}
