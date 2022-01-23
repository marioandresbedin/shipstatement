package com.insurwire.shipstatement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.insurwire.shipstatement.model.Travel;

@Repository
public interface ITravelRepository extends JpaRepository<Travel, Long> {

	@Query("select t from Travel t " + "where 1=1")
	List<Travel> searchTravels(String criteria);

}
