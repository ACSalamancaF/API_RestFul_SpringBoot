package com.dione.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dione.user.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
}