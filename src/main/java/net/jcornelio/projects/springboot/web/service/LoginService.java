package net.jcornelio.projects.springboot.web.service;

import org.springframework.stereotype.Component;

@Component
public class LoginService {

	public boolean validateUser(String userId, String password) {
		return userId.equalsIgnoreCase("Juan") && password.equalsIgnoreCase("123");
	}
	
}
