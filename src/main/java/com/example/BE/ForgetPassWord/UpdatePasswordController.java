package com.example.BE.ForgetPassWord;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UpdatePasswordController {
    private static final Logger logger = LoggerFactory.getLogger(UpdatePasswordController.class);
    @Autowired
    private UpdatePasswordService updatePassServ;

    @PostMapping("/UpdatePassword")
    public ResponseEntity<Boolean> updatepass(@RequestBody UpdatePassword obj) {
    	
        logger.info("Received request: email={}, password=[hidden], confirmPassword=[hidden]", obj.getEmail());
        return ResponseEntity.ok(updatePassServ.updatePassword(obj));
        
    }
}