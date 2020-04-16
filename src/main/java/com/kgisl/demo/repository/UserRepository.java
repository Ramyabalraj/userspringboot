package com.kgisl.demo.repository;

import com.kgisl.demo.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * TeamRepository
 */
public interface UserRepository extends JpaRepository<User,Long>{
 boolean existsByuserEmail(String email);
// boolean findByuserEmailAnduserName(String email,String name);
    
}