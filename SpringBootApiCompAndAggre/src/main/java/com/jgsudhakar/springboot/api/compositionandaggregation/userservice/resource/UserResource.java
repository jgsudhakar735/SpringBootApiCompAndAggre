package com.jgsudhakar.springboot.api.compositionandaggregation.userservice.resource;

import com.jgsudhakar.springboot.api.compositionandaggregation.dto.UserDto;
import com.jgsudhakar.springboot.api.compositionandaggregation.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*************************************
 * This Class is used to 
 * Author  : Sudhakar Tangellapalli
 * File    : com.jgsudhakar.springboot.api.compositionandaggregation.userservice.resource.UserResource
 * Date    : 16-03-2025
 * Version : 1.0
 **************************************/
@RestController
@RequestMapping("api/user")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDto> fetchUserList(){
        return userService.fetchAllUsers();
    }

    @GetMapping("{id}")
    public UserDto fetchUserById(@PathVariable(name = "id") Long id) {
        return userService.getUser(id);
    }
}
