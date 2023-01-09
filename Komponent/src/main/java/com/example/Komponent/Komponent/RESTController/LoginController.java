package com.example.Komponent.Komponent.RESTController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.Komponent.Komponent.model.User;
import com.example.Komponent.Komponent.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class LoginController {

    @Autowired
    private UserService userService;
    
    @PostMapping
    public ResponseEntity<String> authentication(@RequestParam Map<String, String> body ){
        String username = body.get("username");
        String password = body.get("password");

        if(username.isEmpty() || password.isEmpty()){
              return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        else {

            User user = userService.getUserByCredentials(username, password);

            System.out.println("user : "+user);

            ObjectMapper objectmapper = new ObjectMapper();
            String userId = "";
            if(user!=null){

                try {
                    userId = objectmapper.writeValueAsString(user.getId());
                    return new ResponseEntity<>(userId, HttpStatus.OK);
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            }
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);


        }
    }


}
