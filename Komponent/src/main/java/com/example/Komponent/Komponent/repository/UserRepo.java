package com.example.Komponent.Komponent.repository;

import com.example.Komponent.Komponent.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepo extends JpaRepository<User, Integer> {
    /* List<User> findUserByCartExists(); */
    User findByUsernameAndPassword(String username, String password);

    User findByUsername(String username);


}