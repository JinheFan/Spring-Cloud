package com.photoap.users.PhotoAppApiUsers.model;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserRequestModel {
    @NotNull(message = "First Name cannot be null")
    @Size(min = 2, message = "First Name must not be less than two characters")
    private String firstName;

    @NotNull(message = "Last Name cannot be null")
    @Size(min = 2, message = "Last Name must not be less than two characters")
    private String lastName;

    @NotNull(message = "Password cannot be null")
    @Size(min = 2, max = 16, message = "Password length should longer than 2 characters and shorter than 16 characters")
    private String password;

    @NotNull(message = "Email cannot be null")
    @Email
    private String email;
}
