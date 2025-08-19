package com.example.BE.Login;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
	
    @Autowired
    private LoginRepository LoginRepo;
    
    
    public Optional<Object> CheckUser(Login o)
    {
    	
    	
    	try {
    		
    	Optional<Login> exitobj=LoginRepo.findByEmail(o.getEmail());
    	
    	System.out.println(exitobj);
    	
    	if(exitobj.isPresent() && exitobj.get().getPassword().toLowerCase().equals(o.getPassword().toLowerCase()))
    	{
    		
    		return Optional.of(true);
    		
    	}
    	
    	else {
    		
    		return Optional.of(false);
    				
    	}
    	
    		
    		
    		
    	   }
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		return Optional.empty();
    		
    	}
		
}
}