package com.insurwire.shipstatement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.insurwire.shipstatement.model.User;

public interface IUserRepository extends JpaRepository<User, Long> {
	
	User findByEmail(String email);

}