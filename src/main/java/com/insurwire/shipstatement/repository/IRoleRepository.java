package com.insurwire.shipstatement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurwire.shipstatement.model.Role;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {
    
	Role findByName(String name);

}
