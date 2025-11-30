package com.test.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.dto.LoginRequest;
import com.test.service.UserService;

/*1348-User Login & JWT Token Generation
 *Implement secure authentication using Spring Security
 */


@RestController
@RequestMapping("/api/auth")
public class LoginRestController {

	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginRequest request) {
		boolean isValid = userService.login(request.getEmail(), request.getPassword());
		if (isValid) {
			return ResponseEntity.ok().body("Login Successful");
		} else {
			return ResponseEntity.status(401).body("Invalid Username or Password");
		}
	}
           
}
