package com.jgsudhakar.springboot.api.compositionandaggregation.menuservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/*************************************
 * This Class is used to 
 * Author  : Sudhakar Tangellapalli
 * File    : com.jgsudhakar.springboot.api.compositionandaggregation.menuservice.entity.MenuMtbEntity
 * Date    : 16-03-2025
 * Version : 1.0
 **************************************/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "JG_MENU_MTB")
public class MenuMtbEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "MENU_CODE")
    private String menuCode;

    @Column(name = "MENU_NAME")
    private String menuName;

    @Column(name = "MENU_GROUP")
    private String menuGroup;
}
