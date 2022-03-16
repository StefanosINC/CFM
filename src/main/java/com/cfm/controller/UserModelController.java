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
import com.cfm.business.UserModelBusinessInterface;
import com.cfm.models.AddressBookModel;
import com.cfm.models.UserModel;



@Controller
@RequestMapping("/User")
public class UserModelController {

	@Autowired
	private UserModelBusinessInterface service;
	
	@Autowired 
	AddressBookModelBusinessInterface AddressBookService;
	
	@GetMapping(path= {"/"})
	public String RegisterForm(Model model)
	{
		model.addAttribute("title","Register Form");
		model.addAttribute("UserModel", new UserModel());
		return "register";
	}
	
	
	@PostMapping("/doRegister")
	public String doRegister(@Valid UserModel user, BindingResult BindingResult, Model model) {
		
		if(BindingResult.hasErrors()) {
			model.addAttribute("title", "Register Form");
			return "register";
		}
		
		service.Register(user);
		System.out.println(user);
		model.addAttribute("title", " Login Form");
		
		return "login";
		
	}
	
	
	@GetMapping(path= "/login")
	public String displayLogin(Model model) {
		
		model.addAttribute("title","Login Form");
		model.addAttribute("UserModel", new UserModel());
		return "login";
	
		
	}
	
	@PostMapping("/dologin")
	public String LoginForm(@Valid UserModel user, BindingResult BindingResult, Model model) {
		
		//Check for validation Errors
		if(BindingResult.hasErrors())
		{
			model.addAttribute("title", "Login Form");
			return "login";
		}
		
		//If credentials do not match
		if(service.Login(user) == false) {
			return "login";
			
		}
		
		List<AddressBookModel> contacts = AddressBookService.FindAllContacts();
		
		model.addAttribute("title", "AddressBook");
		model.addAttribute("contacts", contacts);
		
		return "AddressBook";
		
	}
	
}
