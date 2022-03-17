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
import com.cfm.business.AddressBookModelBusinessService;
import com.cfm.business.UserModelBusinessInterface;
import com.cfm.business.UserModelBusinessService;
import com.cfm.models.AddressBookModel;
import com.cfm.models.UserModel;



@Controller
@RequestMapping("/")
public class UserModelController {

	@Autowired
	private UserModelBusinessInterface service;
	
	@Autowired 
	AddressBookModelBusinessService AddressBookService;
	
	@GetMapping(path= {"/"})
	public String RegisterForm(Model model)
	{
	
		model.addAttribute("userModel", new UserModel());
		return "register";
	}
	
	
	@PostMapping("/doRegister")
	public String doRegister(@Valid UserModel UserModel, BindingResult BindingResult, Model model) {
		
		if(BindingResult.hasErrors()) {
			
			model.addAttribute("title", "Register Form");	
			System.out.println(" we here");
			return "register";
		}
		
		service.Register(UserModel);
		System.out.println(UserModel);
		
		model.addAttribute("title", " Login Form");
		model.addAttribute("userModel", UserModel);
		return "login";
		
	}
	
	
	
	
	@GetMapping(path= "/login")
	public String displayLogin(Model model) {
		
		model.addAttribute("title","Login Form");
		model.addAttribute("userModel", new UserModel());
		return "login";
	
		
	}
	
	@PostMapping("/doLogin")
	public String LoginForm(@Valid UserModel UserModel, BindingResult BindingResult, Model model) {
		
		//Check for validation Errors
		if(BindingResult.hasErrors())
		{
			model.addAttribute("title", "Form");
			return "login";
		}
		
		
		if(service.Login(UserModel) == false) {
			model.addAttribute("title", "Credentials are Incorrect");
			System.out.println("fail");
			return "login";
		
	}
	
		
		
		
		List<AddressBookModel> contact = AddressBookService.FindAllContacts();
	
	
		model.addAttribute("title", "AddressBook");
		model.addAttribute("contacts", contact);
		
		System.out.println(contact.size());
		return "book";
		
	}
	}

