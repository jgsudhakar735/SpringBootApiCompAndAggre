package com.jgsudhakar.springboot.api.compositionandaggregation.userservice.service;

import com.jgsudhakar.springboot.api.compositionandaggregation.dto.UserDto;
import com.jgsudhakar.springboot.api.compositionandaggregation.userservice.mapper.UserMapper;
import com.jgsudhakar.springboot.api.compositionandaggregation.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/*************************************
 * This Class is used to 
 * Author  : Sudhakar Tangellapalli
 * File    : com.jgsudhakar.springboot.api.compositionandaggregation.userservice.service.UserServiceImpl
 * Date    : 16-03-2025
 * Version : 1.0
 **************************************/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    /**
     * @param userDto
     * @return
     */
    @Override
    public UserDto addUser(UserDto userDto) {
        return userMapper.convertFromEntityToDto(userRepository.save(userMapper.convertFromDtoToEntity(userDto)));
    }

    /**
     * @param id
     * @return
     */
    @Override
    public UserDto getUser(Long id) {
        return userMapper.convertFromEntityToDto(userRepository.findById(id).get());
    }

    /**
     * @param id
     */
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    /**
     * @return
     */
    @Override
    public List<UserDto> fetchAllUsers() {
        return Optional.ofNullable(userRepository.findAll()).orElse(Collections.emptyList()).
                stream().
                map(user-> {
                    return userMapper.convertFromEntityToDto(user);
                }).
                collect(Collectors.toList());
    }
}
