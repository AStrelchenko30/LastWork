package ru.skypro.homework.dto;

import lombok.Data;
import ru.skypro.homework.entity.Image;

import java.util.Arrays;

@Data
public class FullAds {

    private String authorFirstName;
    private  String authorLastName;
    private String description;
    private String email;
    private Image image;
    private String phone;
    private Integer pk;
    private Integer price;
    private String title;
}
