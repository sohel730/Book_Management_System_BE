package com.example.BE.ForgetPassWord;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UpdatePasswordService {
    private static final Logger logger = LoggerFactory.getLogger(UpdatePasswordService.class);
    @Autowired
    private UpdatePasswordRepository updatePassRepo;
    public boolean updatePassword(UpdatePassword o) {
    	
        if (o == null || o.getEmail() == null || o.getPassword() == null || o.getConfirmpassword() == null) {
            logger.warn("Invalid input: email={}, password=[hidden], confirmPassword=[hidden]", o != null ? o.getEmail() : null);
            return false;
        }
        if (!o.getPassword().equals(o.getConfirmpassword())) {
            logger.warn("Password and confirm password do not match for email: {}", o.getEmail());
            return false;
        }
        try {
            logger.info("Querying for email: {}", o.getEmail());
            Optional<UpdatePassword> existingObj = updatePassRepo.findByEmail(o.getEmail());
            if (existingObj.isPresent()) {
                logger.info("Found user with email: {}", o.getEmail());
                existingObj.get().setPassword(o.getPassword());
                updatePassRepo.save(existingObj.get());
                return true;
            }
            logger.warn("No user found with email: {}", o.getEmail());
            return false;
        } catch (Exception e) {
            logger.error("Error updating password for email: {}", o.getEmail(), e);
            return false;
        }
    }
}