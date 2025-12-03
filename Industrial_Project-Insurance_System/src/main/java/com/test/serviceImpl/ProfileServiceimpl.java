package com.test.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.entity.Profile;
import com.test.repository.ProfileRepository;
import com.test.service.ProfileService;

@Service
public class ProfileServiceimpl implements ProfileService{

	@Autowired
	private ProfileRepository profileRepository;
	
	@Override
	public Profile getProfileById(Integer Id) {
		// TODO Auto-generated method stub
		Optional<Profile> profile=profileRepository.findById(Id);
		Profile profile1=profile.get();
		return profile1;
	}

	@Override
	public Profile putProfileById(Profile profile) {
		// TODO Auto-generated method stub
		Profile profile2=profileRepository.save(profile);
		return profile2;
	}

	
	

}
