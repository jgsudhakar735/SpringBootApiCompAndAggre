package com.jgsudhakar.springboot.api.compositionandaggregation.userservice.mapper;

import com.jgsudhakar.springboot.api.compositionandaggregation.dto.UserDto;
import com.jgsudhakar.springboot.api.compositionandaggregation.userservice.entity.UserMtbEntity;
import org.springframework.stereotype.Component;

/*************************************
 * This Class is used to 
 * Author  : Sudhakar Tangellapalli
 * File    : com.jgsudhakar.springboot.api.compositionandaggregation.userservice.mapper.UserMapper
 * Date    : 16-03-2025
 * Version : 1.0
 **************************************/
@Component
public class UserMapper {

    public UserDto convertFromEntityToDto(UserMtbEntity userMtbEntity){
        if(null == userMtbEntity){
            return null;
        }
        UserDto userDto = new UserDto();
        userDto.setId(userMtbEntity.getId());
        userDto.setFirstName(userMtbEntity.getFirstName());
        userDto.setLastName(userMtbEntity.getLastName());
        userDto.setUserGroup(userMtbEntity.getUserGroup());
        return userDto;
    }

    public UserMtbEntity convertFromDtoToEntity(UserDto userDto){
        UserMtbEntity userMtbEntity = new UserMtbEntity();
        userMtbEntity.setId(userDto.getId());
        userMtbEntity.setFirstName(userDto.getFirstName());
        userMtbEntity.setLastName(userDto.getLastName());
        userMtbEntity.setUserGroup(userDto.getUserGroup());
        return userMtbEntity;
    }
}
