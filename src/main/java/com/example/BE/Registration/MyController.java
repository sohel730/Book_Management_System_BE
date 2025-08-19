package com.example.BE.Registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/CreateUser")
    public boolean createUserInTable(@RequestBody Registration user) {
        return registrationService.createUser(user);
    }
}