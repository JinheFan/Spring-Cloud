package com.photoap.users.PhotoAppApiUsers.controllers;

import com.photoap.users.PhotoAppApiUsers.model.UserRequestModel;
import com.photoap.users.PhotoAppApiUsers.model.UserResponseModel;
import com.photoap.users.PhotoAppApiUsers.service.UserService;
import com.photoap.users.PhotoAppApiUsers.shared.UserDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private Environment env;

    @Autowired
    UserService userService;

    @GetMapping("/status/check")
    public String status() {
//        return "Working on the port " + env.getProperty("local.server.port") + ", with token = " + env.getProperty("token.secret");
        return env.getProperty("token.secret");
    }

    @PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserResponseModel> createUser(@Valid @RequestBody UserRequestModel userRequestModel) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserDto userDto = modelMapper.map(userRequestModel, UserDto.class);
        UserDto createdUserDto = userService.create(userDto);

        UserResponseModel createdUserResponseModel = modelMapper.map(createdUserDto, UserResponseModel.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUserResponseModel);
    }
}
