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

import com.insurwire.shipstatement.model.Port;
import com.insurwire.shipstatement.service.PortService;

@Controller
@RequestMapping("/port")
public class PortController {

	@Autowired
	private PortService portService;

	private String add_edit_template = "/admin/port/add-edit-port";
	private String list_template = "/admin/port/list-port";
	private String list_redirect = "redirect:/port/list";

	@GetMapping("/add")
	public String addPort(Port port, Model model) {
		model.addAttribute("port", port);
		return add_edit_template;
	}

	@GetMapping("/edit/{id}")
	public String editPort(@PathVariable("id") int id, Model model) {
		Port port = portService.get(id);

		model.addAttribute("port", port);

		return add_edit_template;
	}

	@PostMapping("/save")
	public String savePort(@Valid @ModelAttribute("port") Port port, BindingResult result,
			Model model) {
		model.addAttribute("port", port);

		if (result.hasErrors()) {
			return add_edit_template;
		}
		portService.save(port);

		return list_redirect + "?success";
	}

	@GetMapping("/delete/{id}")
	public String deletePort(@PathVariable("id") int id, Model model) {
		portService.delete(id);

		return list_redirect + "?deleted";
	}

	@GetMapping("/list")
	public String listPort(Model model) {
		List<Port> listPorts = portService.listAll();
		model.addAttribute("listPorts", listPorts);

		return list_template;
	}

}
