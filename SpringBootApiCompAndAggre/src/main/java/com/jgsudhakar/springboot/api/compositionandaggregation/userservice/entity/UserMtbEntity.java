package com.jgsudhakar.springboot.api.compositionandaggregation.userservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/*************************************
 * This Class is used to 
 * Author  : Sudhakar Tangellapalli
 * File    : com.jgsudhakar.springboot.api.compositionandaggregation.userservice.entity.UserMtbEntity
 * Date    : 16-03-2025
 * Version : 1.0
 **************************************/
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "JG_USER_MTB")
public class UserMtbEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "USER_GROUP")
    private String userGroup;

}
