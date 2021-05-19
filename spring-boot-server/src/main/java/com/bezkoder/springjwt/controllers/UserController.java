package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.payload.response.MessageResponse;
import com.bezkoder.springjwt.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth/user")
public class UserController {

    @Autowired
    UserService userService;


    @PutMapping("/update")

    public ResponseEntity<?> updateUser(@RequestBody User user){
        User newUserData = new User();
        try{
            return ResponseEntity.ok(userService.updateUser(user));
        }
        catch (DataIntegrityViolationException e){
            return ResponseEntity
                        .badRequest()
                        .body(new MessageResponse("Username or Email already taken"));
        }
    }
}


