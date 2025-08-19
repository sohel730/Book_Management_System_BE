package com.example.BE.Login;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Users")
public class Login {
	
	

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "id")	
	 private int id;
	
	
	@Column(name="Email",unique = true)
	private String  email;
	
	@Column(name="Password",unique = true)
	@JsonProperty("Password")
	private String  Password;
	
	 public int getId()
	 {
			return id;
	 }

	public void setId(int id) 
	{
			this.id = id;
	}
		
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	

}
