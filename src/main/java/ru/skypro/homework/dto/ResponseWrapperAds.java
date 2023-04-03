package ru.skypro.homework.dto;

import lombok.Data;


import java.util.List;
/**
 * ResponseWrapperAds
 */
@Data
public class ResponseWrapperAds {

    private Integer count;
    private List<AdsDto> results;
}
