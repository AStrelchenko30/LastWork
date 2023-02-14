package ru.skypro.homework.dto;

import lombok.Data;

@Data
public class UserDto {

    String phone;
    String name;
    String lastName;
    String firstName;
    String email;
    String regDate;
    String city;
    String image;
}
