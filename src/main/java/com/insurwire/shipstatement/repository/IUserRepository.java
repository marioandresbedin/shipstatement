package com.insurwire.shipstatement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurwire.shipstatement.model.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
	
	User findByEmail(String email);

}