package ru.skypro.homework.exceptions;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException() {
        System.out.printf("%s. Пользователь не найден%n", getClass().getSimpleName());
    }
}
