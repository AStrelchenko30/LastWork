package ru.skypro.homework.service;

import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.ResponseWrapperComment;
import ru.skypro.homework.dto.UserDto;
import ru.skypro.homework.entity.UserProfile;

import java.util.List;

public interface UserProfileService {

    /**
     * Метод для создания пользователя
     *
     * @param userProfile новый пользователь
     * @return возвращает экземпляр {@link UserProfile}
     */
    UserProfile createUser(UserProfile userProfile);

    UserDto updateUser(UserDto userProfileNew, Authentication authentication);
    /**
     * Метод для нахождения пользователя
     *
     * @param authentication авторизированный пользователь
     * @return возвращает экземпляр {@link UserDto}
     */
    UserDto findUser(Authentication authentication) ;

    /**
     * Метод удаления пользователя
     *
     * @param id персональный идентификатор пользователя
     * @return экземпляр {@link UserProfile}
     */
    UserProfile deleteUser(Long id);
    /**
     * Метод поиска всех пользователей
     *
     * @return экземпляр {@link List<UserProfile>}
     */
    List<UserProfile> getAllUser();
    /**
     * Метод добавление аватар для пользователя
     *
     * @param image изображение пользователя
     * @param authentication авторизация пользователя
     * @return экземпляр {@link UserDto}, либо {@link RuntimeException}
     */
    UserDto updateUserAvatar(MultipartFile image, Authentication authentication) throws RuntimeException;
}
