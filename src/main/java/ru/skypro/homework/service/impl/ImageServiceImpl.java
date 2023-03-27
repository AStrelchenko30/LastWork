package ru.skypro.homework.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.webjars.NotFoundException;
import ru.skypro.homework.entity.Ads;
import ru.skypro.homework.entity.Image;
import ru.skypro.homework.repository.AdsRepository;
import ru.skypro.homework.repository.ImageRepository;
import ru.skypro.homework.service.ImageService;

import java.io.IOException;
import java.util.UUID;

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

  /*  @Override
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
   */

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


  /*  @Override
    public Image updateAdsImage(Long id, MultipartFile image) {
        Ads imageAds = adsRepository.findAdsById(id);
        try {
            imageAds.setImage(image.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        imageAds.setId(UUID.randomUUID().toString());
        Image savedImage = imageRepository.saveAndFlush(imageAds)
        return ImageMapper.INSTANCE.dtoToImage(image);
    }

   */

    @Override
    public String updateAdsImage(MultipartFile image, Long id) throws RuntimeException {
        Image entity = new Image();
        try {
            byte[] bytes = image.getBytes();
            entity.setImage(bytes);
            Ads ads = adsRepository.findAdsById(id);
            ads.setImage(bytes);
            adsRepository.save(ads);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        entity.setId(UUID.randomUUID().toString());
        Image savedEntity = imageRepository.saveAndFlush(entity);
        return savedEntity.getId();
    }
}
