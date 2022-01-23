package com.insurwire.shipstatement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.insurwire.shipstatement.model.Country;
import com.insurwire.shipstatement.repository.ICountryRepository;

@Service
@Transactional
public class CountryService {

	@Autowired
	private ICountryRepository repo;

	public List<Country> listAll() {
		return (List<Country>) repo.findAll();
	}

	public void save(Country country) {
		repo.save(country);
	}

	public Country get(long id) {
		return repo.findById(id).get();
	}

	public void delete(long id) {
		repo.deleteById(id);
	}

}
