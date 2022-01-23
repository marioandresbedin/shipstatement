package com.insurwire.shipstatement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.insurwire.shipstatement.model.Port;

@Repository
public interface IPortRepository extends JpaRepository<Port, Long> {

	@Query("select p from Port p " + "where 1=1")
	List<Port> listPorts(String criteria);

}
