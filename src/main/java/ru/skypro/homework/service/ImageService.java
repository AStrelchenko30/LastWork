package ru.skypro.homework.service;

import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.UserDto;
import ru.skypro.homework.entity.Image;

public interface ImageService {
    public Image createImage(Image image);

    public Image updateImage(Image imageNew);

    public Image findImage(Long id);

    public Image deleteImage(Long id);
}
