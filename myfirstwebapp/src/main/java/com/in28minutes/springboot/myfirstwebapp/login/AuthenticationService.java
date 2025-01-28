package com.in28minutes.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Service;



@Service
public class AuthenticationService {

	public boolean authenticate(String username, String passwrord) {
		boolean isValidUsername= username.equalsIgnoreCase("vishwa");
		boolean isValidPwd= passwrord.equalsIgnoreCase(passwrord);
		
		return isValidPwd && isValidUsername;
	}
}
