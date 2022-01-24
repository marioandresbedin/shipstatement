package com.insurwire.shipstatement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.insurwire.shipstatement.model.Port;
import com.insurwire.shipstatement.repository.IPortRepository;

@Service
@Transactional
public class PortService {

	@Autowired
	private IPortRepository repo;

	public List<Port> listAll() {
		return (List<Port>) repo.findAll();
	}

	public void save(Port port) {
		repo.save(port);
	}

	public Port get(long id) {
		return repo.findById(id).get();
	}

	public void delete(long id) {
		repo.deleteById(id);
	}

}
