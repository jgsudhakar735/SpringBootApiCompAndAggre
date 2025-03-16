package com.jgsudhakar.springboot.api.composition.gateway.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/*************************************
 * This Class is used to 
 * Author  : Sudhakar Tangellapalli
 * File    : com.jgsudhakar.springboot.api.compositionandaggregation.dto.UserMenuRespose
 * Date    : 16-03-2025
 * Version : 1.0
 **************************************/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserMenuRespose implements Serializable {

    private UserDto userDto;

    private List<MenuDto> menuDto;
}
