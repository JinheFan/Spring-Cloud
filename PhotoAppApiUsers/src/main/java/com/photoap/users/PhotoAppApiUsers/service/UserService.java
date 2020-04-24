package com.photoap.users.PhotoAppApiUsers.service;

import com.photoap.users.PhotoAppApiUsers.shared.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserDto create(UserDto userDto);

    UserDto getUserDetailsByEmail(String email);
}
