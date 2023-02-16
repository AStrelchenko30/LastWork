package ru.skypro.homework.dto;

import lombok.Data;

import java.util.Arrays;

@Data
public class AdsDto {

    private Integer author;
    private Arrays image;
    private Integer pk;
    private Integer price;
    private String title;

}
