package ru.skypro.homework.dto;

import lombok.Data;

@Data
public class UserDto {

    private String phone;
    private String name;
    private String lastName;
    private String firstName;
    private String email;
    private String regDate;
    private String city;
    private String image;
}
