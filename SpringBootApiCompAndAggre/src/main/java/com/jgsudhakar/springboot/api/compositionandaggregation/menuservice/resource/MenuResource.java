package com.jgsudhakar.springboot.api.compositionandaggregation.menuservice.resource;

import com.jgsudhakar.springboot.api.compositionandaggregation.dto.MenuDto;
import com.jgsudhakar.springboot.api.compositionandaggregation.menuservice.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*************************************
 * This Class is used to 
 * Author  : Sudhakar Tangellapalli
 * File    : com.jgsudhakar.springboot.api.compositionandaggregation.menuservice.resource.MenuResource
 * Date    : 16-03-2025
 * Version : 1.0
 **************************************/
@RestController
@RequestMapping("api/menu")
public class MenuResource {

    @Autowired
    private MenuService menuService;

    @GetMapping("{menuGroup}")
    public List<MenuDto> fetchMenuByGroup(@PathVariable(name = "menuGroup") String menuGroup){
        return menuService.fetchMenuByGroup(menuGroup);
    }
}
