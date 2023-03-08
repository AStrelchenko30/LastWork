package ru.skypro.homework.service.impl;

import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import ru.skypro.homework.entity.Image;
import ru.skypro.homework.repository.ImageRepository;
import ru.skypro.homework.service.ImageService;

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

    @Override
    public Image updateImage(Image imageNew) {
        if (imageRepository.findById(imageNew.getId()).isPresent()) {
            Image imageOld = imageRepository.findById(imageNew.getId()).get();
            imageOld.setFileSize(imageNew.getFileSize());
            imageOld.setMediaType(imageNew.getMediaType());
            imageOld.setData(imageNew.getData());
            imageOld.setAds(imageNew.getAds());
            return imageRepository.save(imageOld);
        }
        throw new NotFoundException("Image not found");
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
}
