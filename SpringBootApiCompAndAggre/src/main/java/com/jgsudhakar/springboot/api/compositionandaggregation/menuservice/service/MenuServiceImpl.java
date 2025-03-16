package com.jgsudhakar.springboot.api.compositionandaggregation.menuservice.service;

import com.jgsudhakar.springboot.api.compositionandaggregation.dto.MenuDto;
import com.jgsudhakar.springboot.api.compositionandaggregation.menuservice.mapper.MenuMapper;
import com.jgsudhakar.springboot.api.compositionandaggregation.menuservice.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/*************************************
 * This Class is used to 
 * Author  : Sudhakar Tangellapalli
 * File    : com.jgsudhakar.springboot.api.compositionandaggregation.menuservice.service.MenuServiceImpl
 * Date    : 16-03-2025
 * Version : 1.0
 **************************************/
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private MenuMapper menuMapper;

    /**
     * @param menuDto
     * @return
     */
    @Override
    public MenuDto addMenu(MenuDto menuDto) {
        return menuMapper.convertFromEntityToDto(menuRepository.save(menuMapper.convertFromDtoToEntity(menuDto)));
    }

    /**
     * @param menuGroup
     * @return
     */
    @Override
    public List<MenuDto> fetchMenuByGroup(String menuGroup) {
        return Optional.ofNullable(menuRepository.findByMenuGroup(menuGroup)).orElse(Collections.emptyList()).
                stream().
                map(menu -> {
                 return menuMapper.convertFromEntityToDto(menu);
                }).collect(Collectors.toList());
    }

    /**
     * @return
     */
    @Override
    public List<MenuDto> fetchAllMenus() {
        return null;
    }
}
