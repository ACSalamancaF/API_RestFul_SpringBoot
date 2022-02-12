package com.dione.user.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dione.user.dto.UserDTO;
import com.dione.user.response.dto.MessageResponseDTO;
import com.dione.user.service.UserService;


@RestController
@RequestMapping("user")
public class UserController {

	private UserService userService;

    @Autowired
    public UserController(UserService  userService) {
    	this.userService = userService;

    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public MessageResponseDTO createUser(@RequestBody @Valid UserDTO personDto) {
        return userService.createUser(personDto);
    }
}
