package ru.skypro.homework.service;

import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.entity.Image;

public interface ImageService {

    /**
     * Метод для создания фото для объявления
     *
     * @return возвращает изображение
     */
    Image createImage(Image image);

    /**
     * Метод для нахождения фото объявления
     * @param id персональный идентификатор объявления
     * @return возвращает найденное изображение
     */

    Image findImage(Long id);


    /**
     * Метод для удаления фото объявления
     * @param id персональный идентификатор объявления
     * @return возвращает удаленное изображение
     */
    Image deleteImage(Long id);
    /**
     * Метод получения изображения объявления
     *
     * @param id идентификатор объявления
     * @return возвращает изображение в виде массива байт
     */
    byte[] getPhoto(Long id);
    /**
     * Метод получения изображения пользователя
     *
     *
     * @return возвращает изображение в виде массива байт
     */
   byte[] getPhotoUser();

    /**
     * Метод добавления изображения объявления
     *
     * @param image изображение
     * @param id идентификатор объявления
     * @return возвращает изображение в виде массива байт
     */
    Long updateAdsImage(MultipartFile image, Long id) throws RuntimeException;
}
