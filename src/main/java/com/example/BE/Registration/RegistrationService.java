package com.example.BE.Registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;  // Correct import

@Service  // Now using Spring's @Service
public class RegistrationService {
    
    @Autowired
    private RegistrationRepository ragistrationRepo;  // Changed to lowercase for convention
    
    public boolean createUser(Registration obj) {  // Method name lowercase
        try {
            ragistrationRepo.save(obj);
            return true;
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
