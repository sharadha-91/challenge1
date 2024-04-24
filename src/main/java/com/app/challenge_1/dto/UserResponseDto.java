package com.app.challenge_1.dto;

import com.app.challenge_1.model.User;
import com.app.challenge_1.response.Response;

import com.app.challenge_1.response.ResponseStatus;
import lombok.Data;

@Data
public class UserResponseDto {

    private User user;
    //private Response response;
    private ResponseStatus responseStatus;

}
