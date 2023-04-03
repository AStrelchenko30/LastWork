package ru.skypro.homework.dto;

import lombok.Data;

/**
 * NewPassword
 */
@Data
public class NewPassword {

    private String currentPassword;
    private String newPassword;

}
