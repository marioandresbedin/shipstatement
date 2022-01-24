package com.insurwire.shipstatement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.insurwire.shipstatement.model.TransportType;
import com.insurwire.shipstatement.repository.ITransportTypeRepository;

@Service
@Transactional
public class TransportTypeService {

	@Autowired
	private ITransportTypeRepository repo;

	public List<TransportType> listAll() {
		return (List<TransportType>) repo.findAll();
	}

	public void save(TransportType transportType) {
		repo.save(transportType);
	}

	public TransportType get(long id) {
		return repo.findById(id).get();
	}

	public void delete(long id) {
		repo.deleteById(id);
	}

}
