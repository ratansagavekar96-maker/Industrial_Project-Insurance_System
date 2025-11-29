package com.test.restcontroller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.User;
import com.test.exception.DuplicateEmailException;
import com.test.repository.UserRepository;
import com.test.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    private final UserRepository userRepository;
	
	@Autowired
    private UserService userService;

    UserRestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
	
	@PostMapping("/saveUser")
	public User saveUser(@RequestBody User user) {
		User user1=userService.saveUser(user);
		return user1;
	}
	@PostMapping ("/register")
	public ResponseEntity<?> registerUser(@RequestBody User user) {
		try {
		User saveUser	= userService.registerUser(user);
		return ResponseEntity.status(201).body(Map.of("userId", saveUser.getId(), "message", "User registered Successfully"));
		}catch (DuplicateEmailException e) {
			return ResponseEntity.status(409).body(Map.of("error", e.getMessage()));
		}catch (Exception e) {
			return ResponseEntity.status(400).body(Map.of("error", "Validation failed"));
		}
		
		
		
	}
	
}