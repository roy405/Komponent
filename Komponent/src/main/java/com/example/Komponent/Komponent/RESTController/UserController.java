package com.example.Komponent.Komponent.RESTController;


import com.example.Komponent.Komponent.model.User;
import com.example.Komponent.Komponent.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") int id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public User createUser(@RequestParam Map<String, String> body){
        String first_name = body.get("firstName");
        String last_name = body.get("lastName");
        String username = body.get("username");
        String email = body.get("email");
        String password = body.get("password");
        String cell_phone = body.get("cellphone");
        String dob = body.get("dob");

        User user = new User ();
        user.setFirst_name(first_name);
        user.setLast_name(last_name);
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setCell_phone(cell_phone);
        user.setDob(dob);
        user.setUserType(1);
        return userService.saveUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@RequestParam Map<String, String> body,@PathVariable int id) {

        String first_name = body.get("first_name");
        String last_name = body.get("last_name");
        String username = body.get("username");
        String email = body.get("email");
        String password = body.get("password");
        String cell_phone = body.get("cell_phone");
        String dob = body.get("dob");

        User user = new User ();
        user.setFirst_name(first_name);
        user.setLast_name(last_name);
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setCell_phone(cell_phone);
        user.setDob(dob);
        return userService.updateUser(id,user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
    }




}

