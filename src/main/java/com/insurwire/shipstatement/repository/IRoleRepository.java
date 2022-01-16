package com.insurwire.shipstatement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.insurwire.shipstatement.model.Role;

public interface IRoleRepository extends JpaRepository<Role, Long> {
    
	Role findByName(String name);

}
