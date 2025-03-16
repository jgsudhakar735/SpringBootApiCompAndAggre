package com.jgsudhakar.springboot.api.compositionandaggregation.userservice.service;

import com.jgsudhakar.springboot.api.compositionandaggregation.dto.UserDto;

import java.util.List;

/*************************************
 * This interface is used to 
 * Author  : Sudhakar Tangellapalli
 * File    : com.jgsudhakar.springboot.api.compositionandaggregation.userservice.service.UserService
 * Date    : 16-03-2025
 * Version : 1.0
 **************************************/
public interface UserService {

    public UserDto addUser(UserDto userDto);

    public UserDto getUser(Long id);

    public void deleteUser(Long id);

    public List<UserDto> fetchAllUsers();
}
