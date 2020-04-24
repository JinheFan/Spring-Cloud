package com.photoap.users.PhotoAppApiUsers.shared;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDto implements Serializable {

    private static final long serialVersionUID = -3658498140057012181L;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String userId;

    private String encryptedPassword;

}
