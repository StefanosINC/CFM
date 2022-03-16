package com.cfm.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cfm.business.AddressBookModelBusinessInterface;
import com.cfm.models.AddressBookModel;


@Controller
@RequestMapping("/AddressBook")
public class AddressBookController {

	
	@Autowired 
	AddressBookModelBusinessInterface bookservice;
	

	@GetMapping("/")
	public String DisplayBook(Model model) {
	
		List<AddressBookModel> contact = bookservice.FindAllContacts();
		
		//Display updates Order View
		model.addAttribute("title", "Contacts");
		model.addAttribute("contact", contact);
		return "ContactUI";
	}
	
	@GetMapping("/CreateContactForm")
	public String ContactForm(Model model) {
		
		model.addAttribute("contact", new AddressBookModel());
		return "CreateContactForm";
	}
	
	
	@PostMapping("/doCreateContact")
	public String CreateContact(@Valid AddressBookModel contact, BindingResult bindingResult, Model model) {
		
		
		if (bindingResult.hasErrors())
		{
			model.addAttribute("title", "Create Contact Form");
			return "CreateContactForm";
		}
		
		bookservice.create(contact);
		List<AddressBookModel> contacts = bookservice.FindAllContacts();
		
		//Display updates Order View
		model.addAttribute("title", "Orders");
		model.addAttribute("contact", contacts);
		
		return "ContactUI";
		
}
	
	
	
	
	
}