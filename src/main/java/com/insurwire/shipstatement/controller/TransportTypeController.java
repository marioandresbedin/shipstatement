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

import com.insurwire.shipstatement.model.TransportType;
import com.insurwire.shipstatement.service.TransportTypeService;

@Controller
@RequestMapping("/transporttype")
public class TransportTypeController {

	@Autowired
	private TransportTypeService transportTypeService;

	private String add_edit_template = "admin/transporttype/add-edit-transporttype";
	private String list_template = "admin/transporttype/list-transporttype";
	private String list_redirect = "redirect:transporttype/list";

	@GetMapping("/add")
	public String addTransportType(TransportType transportType, Model model) {
		model.addAttribute("transportType", transportType);
		return add_edit_template;
	}

	@GetMapping("/edit/{id}")
	public String editTransportType(@PathVariable("id") int id, Model model) {
		TransportType transportType = transportTypeService.get(id);

		model.addAttribute("transportType", transportType);

		return add_edit_template;
	}

	@PostMapping("/save")
	public String saveTransportType(@Valid @ModelAttribute("transportType") TransportType transportType,
			BindingResult result, Model model) {
		model.addAttribute("transportType", transportType);

		if (result.hasErrors()) {
			return add_edit_template;
		}
		transportTypeService.save(transportType);

		return list_redirect + "?success";
	}

	@GetMapping("/delete/{id}")
	public String deleteTransportType(@PathVariable("id") int id, Model model) {
		transportTypeService.delete(id);

		return list_redirect + "?deleted";
	}

	@GetMapping("/list")
	public String listTransportType(Model model) {
		List<TransportType> listTransportTypes = transportTypeService.listAll();
		model.addAttribute("listTransportTypes", listTransportTypes);

		return list_template;
	}

}
