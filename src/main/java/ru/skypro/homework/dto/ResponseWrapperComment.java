package ru.skypro.homework.dto;

import lombok.Data;


import java.util.List;
/**
 * ResponseWrapperComment
 */
@Data
public class ResponseWrapperComment {
    private Integer count;
    private List<CommentsDto> results;
}
