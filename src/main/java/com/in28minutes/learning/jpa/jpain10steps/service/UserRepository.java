package com.in28minutes.learning.jpa.jpain10steps.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.learning.jpa.jpain10steps.entity.User;

//we need to specify which entity to manage and we need to provide the primary key fo the entity.
public interface UserRepository extends JpaRepository<User, Long>{

}
