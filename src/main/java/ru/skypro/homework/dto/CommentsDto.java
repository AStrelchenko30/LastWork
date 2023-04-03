package ru.skypro.homework.dto;

import lombok.Data;
/**
 * AdsComment
 */
@Data
public class CommentsDto {

    private Integer author;
    private String createdAt;
    private Long pk;
    private String text;

}
