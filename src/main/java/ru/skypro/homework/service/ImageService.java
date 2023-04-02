package ru.skypro.homework.service;

import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.entity.Image;

public interface ImageService {
    Image createImage(Image image);

    Image findImage(Long id);

    Image deleteImage(Long id);

    byte[] getPhoto(Long id);

  // byte[] getPhotoUser(Authentication authentication);
   byte[] getPhotoUser(Long id);


    Long updateAdsImage(MultipartFile image, Long id) throws RuntimeException;
}
