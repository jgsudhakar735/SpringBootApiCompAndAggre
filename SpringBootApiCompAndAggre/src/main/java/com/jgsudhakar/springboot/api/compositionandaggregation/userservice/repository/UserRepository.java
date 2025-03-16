package com.jgsudhakar.springboot.api.compositionandaggregation.userservice.repository;

import com.jgsudhakar.springboot.api.compositionandaggregation.userservice.entity.UserMtbEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*************************************
 * This interface is used to 
 * Author  : Sudhakar Tangellapalli
 * File    : com.jgsudhakar.springboot.api.compositionandaggregation.userservice.repository.UserRepository
 * Date    : 16-03-2025
 * Version : 1.0
 **************************************/
@Repository
public interface UserRepository extends JpaRepository<UserMtbEntity, Long>{
}
