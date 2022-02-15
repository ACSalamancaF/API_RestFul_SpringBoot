package com.dione.user.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dione.user.dto.UserDTO;
import com.dione.user.dto.response.MessageResponseDTO;
import com.dione.user.exception.UserNotFoundException;
import com.dione.user.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/user")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {
	
	private UserService userService;
	
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public MessageResponseDTO createUser(@RequestBody @Valid UserDTO userDto) {
        return userService.createUser(userDto);
    }
    
    @GetMapping(value="/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public UserDTO findById(@PathVariable Long id) throws UserNotFoundException {
    	return userService.findByID(id);
    }
    
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<UserDTO> findAll(){
		return userService.listAll();
    	
    }
    
    @DeleteMapping(value="/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteById(@PathVariable Long id) throws UserNotFoundException{
    	userService.delete(id);
    }
}
