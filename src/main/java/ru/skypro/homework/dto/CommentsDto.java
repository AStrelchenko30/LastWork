package ru.skypro.homework.dto;

import lombok.Data;

@Data
public class CommentsDto {
    Integer author;
    String createdAt;
    Integer pk;
    String text;

}
