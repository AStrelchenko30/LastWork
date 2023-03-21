package ru.skypro.homework.exceptions;

public class ForbiddenException extends RuntimeException {

    public ForbiddenException() {
        System.out.printf("%s. Неверные данные%n", getClass().getSimpleName());
    }
}
