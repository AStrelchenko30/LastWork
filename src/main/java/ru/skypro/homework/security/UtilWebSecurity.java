package ru.skypro.homework.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import ru.skypro.homework.entity.UserProfile;

public interface UtilWebSecurity {

    default String login() {
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return principal.getUsername();
    }

    default UserProfile getUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserProfile user = (UserProfile) auth.getPrincipal();
        return user;
    }

}
