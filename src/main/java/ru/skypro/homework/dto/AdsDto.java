package ru.skypro.homework.dto;

import lombok.Data;

import java.lang.reflect.Array;
@Data
public class AdsDto {

    Integer author;
    Array image;
    Integer pk;
    Integer price;
    String title;

}
