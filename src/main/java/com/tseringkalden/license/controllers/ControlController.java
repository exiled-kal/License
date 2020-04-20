package com.tseringkalden.license.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tseringkalden.license.models.License;
import com.tseringkalden.license.models.Person;
import com.tseringkalden.license.services.LicenseService;



@Controller
public class ControlController {
	private final LicenseService licenseService;
	
	public ControlController(LicenseService licenseService) {
		this.licenseService = licenseService;
	}
	
	@RequestMapping("/")
	public String index() {
			return "redirect:/person/new";
		
	}
	
	@GetMapping("person/new")
	public String addPerson(@ModelAttribute("person") Person person) {
		return "person.jsp";
	
	}
	@PostMapping("persons/new") 
	public String processAddPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if(result.hasErrors()) {
			return "person.jsp";
		}
		else {
			licenseService.addPerson(person);
			return "redirect:/license/new";
		}
	}
	
	@GetMapping("license/new")
	public String addLicense(@ModelAttribute("license")License license, Model model) {
		List<Person> persons = licenseService.allPersons();
		model.addAttribute("persons",persons);
		return"license.jsp";
		
	}
	
	@PostMapping("license/new")
	public String processLicense(@Valid @ModelAttribute("license") License license, BindingResult result,Model model) {
		if(result.hasErrors()) {
			List<Person> persons = licenseService.allPersons();
			model.addAttribute("persons",persons);
			return "license.jsp";
		}
		else {
			String number = licenseService.generateLicenseNumber();
			license.setNumber(number);
//			System.out.println(license.getNumber());
//			System.out.println(license.getState());
//			System.out.println(license.getExpiration_date());
//			System.out.println(license.getPerson());
			licenseService.addLicense(license);
			return"redirect:/persons/"+license.getId();
			
		}
	}
	
	@RequestMapping("/persons/{personId}")
	public String setUpView(@PathVariable("personId")Long id,Model model) {
		Date date = licenseService.getLicense(id).get().getExpiration_date();
		String pattern ="MM/dd/yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		model.addAttribute("date",simpleDateFormat.format(date));
		model.addAttribute("license",licenseService.getLicense(id).get());
		return"info.jsp";
	}
}
