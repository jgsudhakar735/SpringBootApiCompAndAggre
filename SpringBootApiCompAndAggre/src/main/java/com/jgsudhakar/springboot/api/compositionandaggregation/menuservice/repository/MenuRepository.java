package com.jgsudhakar.springboot.api.compositionandaggregation.menuservice.repository;

import com.jgsudhakar.springboot.api.compositionandaggregation.menuservice.entity.MenuMtbEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*************************************
 * This interface is used to 
 * Author  : Sudhakar Tangellapalli
 * File    : com.jgsudhakar.springboot.api.compositionandaggregation.menuservice.repository.MenuRepository
 * Date    : 16-03-2025
 * Version : 1.0
 **************************************/
@Repository
public interface MenuRepository extends JpaRepository<MenuMtbEntity,Long> {
    public List<MenuMtbEntity> findByMenuGroup(String menuGroup);
}
