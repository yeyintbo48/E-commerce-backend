package com.project.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.ecommerce.dto.UserRegistrationDto;
import com.project.ecommerce.model.User;
import com.project.ecommerce.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRegistrationDto registrationDto){
        try{
            User registerUser = userService.registerNewUser(registrationDto);
            return ResponseEntity.ok(registerUser);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Error registering user: " + e.getMessage());
        }
    }
}
