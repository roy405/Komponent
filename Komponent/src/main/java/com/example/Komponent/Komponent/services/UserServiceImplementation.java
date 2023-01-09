package com.example.Komponent.Komponent.services;


import com.example.Komponent.Komponent.model.User;
import com.example.Komponent.Komponent.repository.UserRepo;
import com.example.Komponent.Komponent.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepo repository;

    @Override
    public User saveUser(User user) {
        User userAvailable = repository.findByUsername(user.getUsername());
        if (userAvailable==null) {
            user.setUserType(1);
            return repository.save(user);

        }
        return null;

    }

    @Override
    public User getUserById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteUser(int id) { User user = repository.findById(id).orElse(null);
        repository.delete(user);
    }

    @Override
    public List<User> getAllUsers() { return repository.findAll(); }

    @Override
    public User getUserByCredentials(String username, String password) {
        return repository.findByUsernameAndPassword(username, password);
    }

    @Override
    public User updateUser(int id, User newUser) {
        Optional<User> userOptional = repository.findById(id);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            user.setLast_name(newUser.getLast_name());
            user.setDob(newUser.getDob());
            user.setCell_phone(newUser.getCell_phone());
            user.setPassword(newUser.getPassword());
            user.setEmail(newUser.getEmail());
            user.setUsername(newUser.getUsername());
            user.setFirst_name(newUser.getFirst_name());

            return repository.save(user);
        }
        return null;
    }

}
