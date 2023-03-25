package ru.skypro.homework.service;

import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.UserDto;
import ru.skypro.homework.entity.Image;

public interface ImageService {
    Image createImage(Image image);

    Image updateAdsImage(Long id, MultipartFile image);

    String savePhoto(MultipartFile file);

    Image findImage(Long id);

    Image deleteImage(Long id);

    byte[] getPhoto(Long id);


}
