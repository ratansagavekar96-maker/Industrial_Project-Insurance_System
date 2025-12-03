package com.test.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Profile;
import com.test.service.ProfileService;

@RestController
@RequestMapping("/api/users")
public class ProfileRestcontroller {
	
	@Autowired
	private ProfileService profileService;
	
	@GetMapping("/getProfile/{id}")
	public Profile getProfileById(@PathVariable("id")Integer id) {
		
		Profile profile=profileService.getProfileById(id);
		return profile;
	}
	
	@PutMapping("/putProfile")
	
	public Profile putProfileById(@RequestBody Profile profile) {
		Profile profile1=profileService.putProfileById(profile);
		return profile1;
		
	}

}
