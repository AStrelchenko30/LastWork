package ru.skypro.homework.dto;

import lombok.Data;

import java.util.Arrays;

@Data
public class FullAds {

    private String authorFirstName;
    private  String authorLastName;
    private String description;
    private String email;
    private Arrays image;
    private String phone;
    private Integer pk;
    private Integer price;
    private String title;
}
