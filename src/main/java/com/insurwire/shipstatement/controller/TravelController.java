package com.insurwire.shipstatement.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.insurwire.shipstatement.model.Country;
import com.insurwire.shipstatement.model.Port;
import com.insurwire.shipstatement.model.TransportType;
import com.insurwire.shipstatement.model.Travel;
import com.insurwire.shipstatement.service.CountryService;
import com.insurwire.shipstatement.service.PortService;
import com.insurwire.shipstatement.service.TransportTypeService;
import com.insurwire.shipstatement.service.TravelService;

@Controller
@RequestMapping("/travel")
public class TravelController {

	@Autowired
	private TravelService travelService;
	
	@Autowired
	private TransportTypeService transportTypeService;
	
	@Autowired
	private PortService portervice;
	
	@Autowired
	private CountryService countryService;

	private String add_edit_template = "/admin/travel/add-edit-travel";
	private String list_template = "/admin/travel/list-travel";
	private String list_redirect = "redirect:/travel/list";

	@GetMapping("/add")
	public String addTravel(Travel travel, Model model) {
		
		travel.setTravelCode("TRAVEL-1");
		model.addAttribute("travel", travel);

		// TODO add Lists required to add a travel: countries, ports, transpor types

		List<TransportType> transportTypes = transportTypeService.listAll();
		model.addAttribute("transportTypes", transportTypes);
		
		List<Country> countries = countryService.listAll();
		model.addAttribute("countries", countries);
		
		List<Port> ports = portervice.listAll();
		model.addAttribute("ports", ports);
		

		return add_edit_template;
	}

	@GetMapping("/edit/{id}")
	public String editProduct(@PathVariable("id") long id, Model model) {
		Travel travel = travelService.get(id);
		model.addAttribute("travel", travel);

		List<TransportType> transportTypes = transportTypeService.listAll();
		model.addAttribute("transportTypes", transportTypes);
		
		List<Country> countries = countryService.listAll();
		model.addAttribute("countries", countries);
		
		List<Port> ports = portervice.listAll();
		model.addAttribute("ports", ports);

		return add_edit_template;
	}

	@PostMapping("/save")
	public String saveTravel(@Valid @ModelAttribute("travel") Travel travel, BindingResult result, Model model) {
		model.addAttribute("travel", travel);

		if (result.hasErrors()) {
			return add_edit_template;
		}
		
		travel.setStatus("presentado");
		travelService.save(travel);
		return list_redirect + "?success";
	}

	@GetMapping("/delete/{id}")
	public String deleteTravel(@PathVariable("id") long id, Model model) {
		travelService.delete(id);

		return list_redirect + "?deleted";
	}

	@GetMapping("/list")
	public String listTravels(Model model) {

		List<Travel> listTravels = travelService.listAll();
		model.addAttribute("listTravels", listTravels);
		
		List<TransportType> transportTypes = transportTypeService.listAll();
		model.addAttribute("transportTypes", transportTypes);
		
		List<Country> countries = countryService.listAll();
		model.addAttribute("countries", countries);
		
		List<Port> ports = portervice.listAll();
		model.addAttribute("ports", ports);

		return list_template;
	}

}
