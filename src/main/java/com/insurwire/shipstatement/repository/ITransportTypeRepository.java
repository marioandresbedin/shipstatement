package com.insurwire.shipstatement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.insurwire.shipstatement.model.TransportType;

@Repository
public interface ITransportTypeRepository extends JpaRepository<TransportType, Long> {

	@Query("select tp from TransportType tp " + "where 1=1")
	List<TransportType> listTransportTypes(String criteria);

}
