package com.example.Komponent.Komponent.RESTController;

import com.example.Komponent.Komponent.model.User;
import com.example.Komponent.Komponent.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/adminReg")
@CrossOrigin("http://localhost:3005")
public class AdminRegistrationController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.saveUser(user);
    }
}
