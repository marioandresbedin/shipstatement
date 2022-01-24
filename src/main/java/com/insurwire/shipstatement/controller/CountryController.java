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
import com.insurwire.shipstatement.service.CountryService;

@Controller
@RequestMapping("/country")
public class CountryController {

	@Autowired
	private CountryService countryService;

	private String add_edit_template = "admin/country/add-edit-country";
	private String list_template = "admin/country/list-country";
	private String list_redirect = "redirect:/country/list";

	@GetMapping("/add")
	public String addProductType(Country country, Model model) {
		model.addAttribute("country", country);
		return add_edit_template;
	}

	@GetMapping("/edit/{id}")
	public String editCountry(@PathVariable("id") int id, Model model) {
		Country country = countryService.get(id);

		model.addAttribute("country", country);

		return add_edit_template;
	}

	@PostMapping("/save")
	public String saveProductType(@Valid @ModelAttribute("country") Country country, BindingResult result,
			Model model) {
		model.addAttribute("country", country);

		if (result.hasErrors()) {
			return add_edit_template;
		}
		countryService.save(country);

		return list_redirect + "?success";
	}

	@GetMapping("/delete/{id}")
	public String deleteCountry(@PathVariable("id") int id, Model model) {
		countryService.delete(id);

		return list_redirect + "?deleted";
	}

	@GetMapping("/list")
	public String listCountry(Model model) {
		List<Country> listCountries = countryService.listAll();
		model.addAttribute("listCountries", listCountries);

		return list_template;
	}

}
