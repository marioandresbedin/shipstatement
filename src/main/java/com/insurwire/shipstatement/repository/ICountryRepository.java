package com.insurwire.shipstatement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.insurwire.shipstatement.model.Country;

@Repository
public interface ICountryRepository extends JpaRepository<Country, Long> {

	@Query("select c from Country c " + "where 1=1")
	List<Country> listCountries(String criteria);

}
