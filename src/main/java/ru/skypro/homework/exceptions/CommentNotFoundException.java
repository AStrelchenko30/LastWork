package ru.skypro.homework.exceptions;

public class CommentNotFoundException extends RuntimeException{

    public void commentNotFoundException() {
        System.out.printf("%s. Комментарий не найден%n", getClass().getSimpleName());
    }
}
