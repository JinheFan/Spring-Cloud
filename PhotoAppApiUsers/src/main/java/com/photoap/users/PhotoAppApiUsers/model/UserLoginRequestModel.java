package com.photoap.users.PhotoAppApiUsers.model;

import lombok.Data;

@Data
public class UserLoginRequestModel {

    private String email;

    private String password;
}
