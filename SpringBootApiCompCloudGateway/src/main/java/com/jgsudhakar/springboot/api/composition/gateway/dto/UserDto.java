package com.jgsudhakar.springboot.api.composition.gateway.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/*************************************
 * This Class is used to 
 * Author  : Sudhakar Tangellapalli
 * File    : com.jgsudhakar.springboot.api.compositionandaggregation.dto.UserDto
 * Date    : 16-03-2025
 * Version : 1.0
 **************************************/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {

    private Long id;

    private String firstName;

    private String lastName;

    private String userGroup;
}
