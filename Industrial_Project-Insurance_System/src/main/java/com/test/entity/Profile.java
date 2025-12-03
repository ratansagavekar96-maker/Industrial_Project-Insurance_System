package com.test.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="profile")
public class Profile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long profileId;
	private String address;
	private String city;
	private String state;
	private String pinCode;
	
	@OneToOne(targetEntity = User.class, cascade = CascadeType.ALL)
	private User user;

	public Long getProfileId() {
		return profileId;
	}

	public void setProfileId(Long profileId) {
		this.profileId = profileId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Profile [profileId=" + profileId + ", address=" + address + ", city=" + city + ", state=" + state
				+ ", pinCode=" + pinCode + ", user=" + user + "]";
	}

	


}

