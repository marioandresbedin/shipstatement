package com.insurwire.shipstatement.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.insurwire.shipstatement.model.User;
import com.insurwire.shipstatement.web.dto.UserRegistrationDto;

public interface IUserService extends UserDetailsService {
	
	User save(UserRegistrationDto registrationDto);

	User findByUsername(String username);
}
