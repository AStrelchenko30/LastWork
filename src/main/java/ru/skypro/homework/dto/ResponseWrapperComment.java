package ru.skypro.homework.dto;

import lombok.Data;

;
import java.util.Arrays;

@Data
public class ResponseWrapperComment {
    Integer count;
    Arrays results;
}
