package ru.skypro.homework.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.webjars.NotFoundException;
import ru.skypro.homework.entity.Ads;
import ru.skypro.homework.dto.AdsDto;
import ru.skypro.homework.dto.UserDto;
import ru.skypro.homework.entity.Ads;
import ru.skypro.homework.entity.Image;
import ru.skypro.homework.mappers.ImageMapper;
import ru.skypro.homework.repository.AdsRepository;
import ru.skypro.homework.repository.ImageRepository;
import ru.skypro.homework.service.ImageService;

@Service
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;
    private final AdsRepository adsRepository;

    public ImageServiceImpl(ImageRepository imageRepository, AdsRepository adsRepository) {
        this.imageRepository = imageRepository;
        this.adsRepository = adsRepository;
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
            imageRepository.save(imageOld);
            return ImageMapper.INSTANCE.dtoToImage(imageNew);
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


    @Override
    public byte[] getPhoto(Long id) {

        Image image = imageRepository.getReferenceById(id);
        return image.getData();
    }


    @Override
    public Image updateAdsImage(Long id, Image image) {
        Ads imageAds = adsRepository.findAdsById(id);
        imageAds.setImage(image);
        return ImageMapper.INSTANCE.dtoToImage(image);
    }
}
