package com.example.Komponent.Komponent.services;

import com.example.Komponent.Komponent.model.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    User saveUser(User user);

    User getUserById(int id);

    void deleteUser(int id);

    List<User> getAllUsers();

    User getUserByCredentials(String email, String password);

    User updateUser(int id,User user);

    /* List<User> getAllUsersThatShoppedOnFourthOfJuly(); */
}
