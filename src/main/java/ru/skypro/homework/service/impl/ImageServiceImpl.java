package ru.skypro.homework.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.webjars.NotFoundException;
import ru.skypro.homework.dto.AdsDto;
import ru.skypro.homework.dto.UserDto;
import ru.skypro.homework.entity.Ads;
import ru.skypro.homework.entity.Image;
import ru.skypro.homework.mappers.ImageMapper;
import ru.skypro.homework.repository.ImageRepository;
import ru.skypro.homework.service.ImageService;

import java.io.IOException;
import java.util.UUID;

@Service
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;

    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public Image createImage(Image image) {
        if (!imageRepository.findAll().contains(image)) {
            imageRepository.save(image);
        }
        throw new NotFoundException("Image already exist");
    }

   /* public Image savePhoto(MultipartFile file) {
        Image image=new Image();
        image.setFileSize(file.getSize());
        image.setMediaType(file.getContentType());
        try {
            image.setData(file.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return imageRepository.save(image);
    }*/

   @Override
    public Image savePhoto(MultipartFile image) {
        Image imageEntity = new Image();
        try {
            byte[] bytes = image.getBytes();
            imageEntity.setData(bytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        imageEntity.setId(UUID.randomUUID().toString());

        return imageRepository.saveAndFlush(imageEntity);
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
        return image.getData();
    }

}
