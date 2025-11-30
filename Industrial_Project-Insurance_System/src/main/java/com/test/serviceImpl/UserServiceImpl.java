package com.test.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.entity.User;
import com.test.exception.DuplicateEmailException;
import com.test.repository.UserRepository;
import com.test.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		User user1 = userRepository.save(user);
		return user1;
	}

	@Override
	public User registerUser(User user) {
		Optional<User> userEmail = userRepository.findByEmail(user.getEmail());
				userEmail.ifPresent(s-> { throw new DuplicateEmailException("Email already Exits");
		});
		
		user.setPassword(user.getPassword());
		
		User user1 = userRepository.save(user);
		return user1;
	}

	@Override
	public boolean login(String email,String password) {
		 User user1=userRepository.findByEmailAndPassword(email, password);
		 return user1!=null;
	}

}
