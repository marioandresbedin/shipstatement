package com.insurwire.shipstatement.service;

import com.insurwire.shipstatement.model.Travel;
import com.insurwire.shipstatement.web.dto.TravelRegistrationDto;

public interface ITravelService {

	Travel save(TravelRegistrationDto travelDto);

	Travel findByTravelCode(String travelCode);
	
}
