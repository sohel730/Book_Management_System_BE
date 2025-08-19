package com.example.BE.Login;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api")
public class LoginController {
	
	@Autowired
	private LoginService LoginServ;
	
	
	@PostMapping("/Login")
	public ResponseEntity<Optional<Object>> checklogin(@RequestBody Login o)
	{
		
		Optional<Object> exists=LoginServ.CheckUser(o);
		return ResponseEntity.ok(exists);
		
		
		
	}
	

}
