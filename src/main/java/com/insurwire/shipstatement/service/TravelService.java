package com.insurwire.shipstatement.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.insurwire.shipstatement.model.Travel;
import com.insurwire.shipstatement.repository.ITravelRepository;

@Service
@Transactional
public class TravelService {

	@Autowired
	private ITravelRepository travelRepository;

	public List<Travel> listAll() {
		return travelRepository.findAll();
	}

	public Page<Travel> findPaginated(String search, Pageable pageable) {
		List<Travel> travels = travelRepository.searchTravels(search); // repo.findAll();

		int pageSize = pageable.getPageSize();
		int currentPage = pageable.getPageNumber();
		int startItem = currentPage * pageSize;
		List<Travel> list;

		if (travels.size() < startItem) {
			list = Collections.emptyList();
		} else {
			int toIndex = Math.min(startItem + pageSize, travels.size());
			list = travels.subList(startItem, toIndex);
		}

		Page<Travel> bookPage = new PageImpl<Travel>(list, PageRequest.of(currentPage, pageSize), travels.size());

		return bookPage;
	}

	public void save(Travel travel) {
		travelRepository.save(travel);
	}

	public Travel get(long id) {
		return travelRepository.findById(id).get();
	}

	public void delete(long id) {
		travelRepository.deleteById(id);
	}

}
