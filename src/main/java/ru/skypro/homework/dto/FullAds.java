package ru.skypro.homework.dto;

import lombok.Data;

import java.lang.reflect.Array;

@Data
public class FullAds {

    String authorFirstName;
    String authorLastName;
    String description;
    String email;
    Array image;
    String phone;
    Integer pk;
    Integer price;
    String title;
}
