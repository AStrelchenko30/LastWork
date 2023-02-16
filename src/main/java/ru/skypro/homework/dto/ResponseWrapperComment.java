package ru.skypro.homework.dto;

import lombok.Data;

;
import java.util.Arrays;

@Data
public class ResponseWrapperComment {
    private Integer count;
    private Arrays results;
}
