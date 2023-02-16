package ru.skypro.homework.dto;

import lombok.Data;

import java.util.Arrays;

@Data
public class ResponseWrapperAds {

    private Integer count;
    private Arrays results;
}
