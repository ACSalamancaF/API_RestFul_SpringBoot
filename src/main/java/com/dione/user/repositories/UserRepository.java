package com.dione.user.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dione.user.entities.User;

//gerenciador de comunicação com o banco de dados.

public interface UserRepository extends JpaRepository<User, Long>{

}