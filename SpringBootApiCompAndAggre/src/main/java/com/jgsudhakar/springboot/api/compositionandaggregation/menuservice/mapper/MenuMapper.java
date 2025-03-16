package com.jgsudhakar.springboot.api.compositionandaggregation.menuservice.mapper;

import com.jgsudhakar.springboot.api.compositionandaggregation.dto.MenuDto;
import com.jgsudhakar.springboot.api.compositionandaggregation.menuservice.entity.MenuMtbEntity;
import org.springframework.stereotype.Component;

/*************************************
 * This Class is used to 
 * Author  : Sudhakar Tangellapalli
 * File    : com.jgsudhakar.springboot.api.compositionandaggregation.menuservice.mapper.MenuMapper
 * Date    : 16-03-2025
 * Version : 1.0
 **************************************/
@Component
public class MenuMapper {

    public MenuDto convertFromEntityToDto(MenuMtbEntity menuMtbEntity){
        if(menuMtbEntity == null){
            return null;
        }
        MenuDto menuDto = new MenuDto();
        menuDto.setId(menuMtbEntity.getId());
        menuDto.setMenuGroup(menuMtbEntity.getMenuGroup());
        menuDto.setMenuName(menuMtbEntity.getMenuName());
        menuDto.setMenuCode(menuMtbEntity.getMenuCode());
        return menuDto;
    }

    public MenuMtbEntity convertFromDtoToEntity(MenuDto menuDto){
        MenuMtbEntity menuMtbEntity = new MenuMtbEntity();
        menuMtbEntity.setId(menuDto.getId());
        menuMtbEntity.setMenuGroup(menuDto.getMenuGroup());
        menuMtbEntity.setMenuName(menuDto.getMenuName());
        menuMtbEntity.setMenuCode(menuDto.getMenuCode());
        return menuMtbEntity;
    }
}
