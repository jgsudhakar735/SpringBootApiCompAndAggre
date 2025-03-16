package com.jgsudhakar.springboot.api.compositionandaggregation.menuservice.service;

import com.jgsudhakar.springboot.api.compositionandaggregation.dto.MenuDto;

import java.util.List;

/*************************************
 * This Class is used to 
 * Author  : Sudhakar Tangellapalli
 * File    : com.jgsudhakar.springboot.api.compositionandaggregation.menuservice.service.MenuService
 * Date    : 16-03-2025
 * Version : 1.0
 **************************************/
public interface MenuService {

    public MenuDto addMenu(MenuDto menuDto);

    public List<MenuDto> fetchMenuByGroup(String menuGroup);

    public List<MenuDto> fetchAllMenus();
}
