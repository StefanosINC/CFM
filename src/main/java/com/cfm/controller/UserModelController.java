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


import com.cfm.business.AddressBookModelBusinessService;
import com.cfm.business.UserModelBusinessInterface;
import com.cfm.business.UserModelBusinessService;
import com.cfm.data.AddressBookDataInterface;
import com.cfm.models.AddressBookModel;
import com.cfm.models.UserModel;
import com.cfm.business.AddressBookModelBusinessInterface;

/*
 * This is the controller for the UserModel services
 * This controller is responsible for inheriting the Business Services instantiated and then passing them to the view MVC.
 * @Controller, @RequestMapping
 */
@Controller
@RequestMapping("/")
public class UserModelController {

	/*
	 * Autowire the UserModelInterface
	 */
	@Autowired
	private UserModelBusinessInterface service;
	
	/*
	 * Autowire the AddressBookDataInterface Service
	 */
	@Autowired
	private AddressBookDataInterface AddressBookService;
	
	
	/*
	 * This will be the first page the user sees!
	 * Route this to the Register
	 * Instantiate a userModel object
	 * @Param - @Getmapping, Model
	 * @Return, Register.html
	 */
	@GetMapping(path= {"/"})
	public String RegisterForm(Model model)
	{
	
		model.addAttribute("userModel", new UserModel());
		return "register";
	}
	
	
	/*
	 * This is the Register Action Method
	 * This method will call on the Register method in the service to process the new user.
	 * This also invokes datavalidation.
	 * @Param -@Valid UserModel UserModel, BindingResult BindingResult, Model model
	 * @Return - login.html, and a UserModel
	 */
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
	
	
	
	/*
	 * This is the original Route for the Login service
	 * This instantiates a UserModel object
	 * @Param - Model,
	 * @Return - login.html and passes in the UserModel if it wasnt created before
	 */
	@GetMapping(path= "/login")
	public String displayLogin(Model model) {
		
		model.addAttribute("title","Login Form");
		model.addAttribute("userModel", new UserModel());
		return "login";
	
		
	}
	
	
	/*
	 * This is the Login Action method that actually proceeds the login
	 * This method is responsible for validating the user is in teh DB and returning the addresbook page
	 * This also invokes data validation
	 * @Param - @Valid UserModel UserModel, BindingResult BindingResult, Model model
	 * @Return - a sucessfull, or failure login attempt, and the addresbook!
	 */
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

