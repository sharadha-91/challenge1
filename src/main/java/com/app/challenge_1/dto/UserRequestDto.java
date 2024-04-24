package com.app.challenge_1.dto;

import lombok.Data;

@Data
public class UserRequestDto {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

}
