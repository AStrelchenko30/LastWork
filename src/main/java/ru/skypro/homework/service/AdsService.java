package ru.skypro.homework.service;

import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.*;
import ru.skypro.homework.entity.Ads;
import ru.skypro.homework.entity.Comment;

import java.util.List;


public interface AdsService {

    /**
     * Метод для получения списка всех объявлений с указанием их количества
     *
     * @return возвращает экземпляр {@link ResponseWrapperAds}
     */
    ResponseWrapperAds getAllAds();

    /**
     * Метод создания объявления
     *
     * @param ads объявление
     * @param image фото объявления
     * @return возвращает экземпляр {@link AdsDto}
     */
    AdsDto createAds(CreateAds ads, MultipartFile image);

    /**
     * Метод для получения списка всех комментариев одного объявления и указанием их количества
     *
     * @param adPk ключ объявления
     * @return возвращает экземпляр {@link ResponseWrapperComment}
     */
    ResponseWrapperComment getComments(Long adPk);


    /**
     * Метод для добавления комментариев к объявлению
     *
     * @param adPk    ключ, соответствующий данному {@link Comment}
     * @param comment сущность комментария с ключевым полем "text"
     * @return возвращает добавленный экземпляр {@link CommentsDto}
     */
    CommentsDto addAdsComment(Long adPk, CommentsDto comment, Authentication authentication);

    /**
     * Получение полной информации об объявлении (в т.ч. об авторе)
     *
     * @param id             идентификатор объявления
     * @param authentication авторизация пользовтеля
     * @return возвращает экземпляр {@link FullAds}
     */
    FullAds getFullAds(Long id, Authentication authentication);

    /**
     * Метод для удаления объявления
     *
     * @param id идентификатор объявления
     * @return возвращает удалённый {@link AdsDto} в случае успеха, либо {@link ru.skypro.homework.exceptions.AdsNotFoundException}
     */
    AdsDto removeAds(Long id);

    /**
     * Метод изменения объявления
     *
     * @param Id        идентификатор объявления
     * @param createAds изменённое объявление
     * @return возвращает изменённый экземпляр {@link AdsDto}
     */
    AdsDto updateAds(Long Id, CreateAds createAds);

    /**
     * Метод для получения списка всех комментариев одного объявления и указанием их количества
     *
     * @param adPk ключ объявления
     * @param Id   индетификатор комментария
     * @return возвращает экземпляр {@link CommentsDto}
     */
    CommentsDto getAdsComment(Long adPk, Long Id);

    /**
     * Метод для удаления комментария
     *
     * @param adPk ключ объявления, в котором написан комментарий
     * @param Id   идентификатор комментария
     * @return удалённый {@link CommentsDto}
     */

    CommentsDto deleteAdsComment(Long adPk, Long Id);

    /**
     * Метод для изменения комментария
     *
     * @param adPk          ключ объявления
     * @param Id          идентификатор комментария
     * @param comment изменённый комментарий
     * @return возвращает изменённый экземпляр {@link Comment}
     */
    Comment updateComment(Long adPk, Long Id, Comment comment);

    ResponseWrapperAds getAdsMeUsingGET(Authentication authentication);

    /**
     * Нахождение комментария по названию
     *
     * @param title название комментария
     * @return возвращает список найденных объявлений {@link List<Ads>}
     */
    List<Ads> findAdsByTitle(String title);


}
