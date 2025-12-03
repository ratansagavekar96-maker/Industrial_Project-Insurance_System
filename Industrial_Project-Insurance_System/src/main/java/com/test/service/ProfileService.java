package com.test.service;

import com.test.entity.Profile;

public interface ProfileService {
	
	public Profile getProfileById(Integer Id);
	
	public Profile putProfileById(Profile profile);

}
