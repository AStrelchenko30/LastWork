package ru.skypro.homework.exceptions;

public class AdsNotFoundException extends RuntimeException{

    public void AdsNotFoundException() {
        System.out.printf("%s. Объявление не найдено%n", getClass().getSimpleName());
    }
}
