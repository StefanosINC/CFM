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
import org.springframework.web.bind.annotation.RequestParam;

import com.cfm.business.AddressBookModelBusinessInterface;
import com.cfm.business.AddressBookModelBusinessService;
import com.cfm.data.AddressBookDataInterface;
import com.cfm.models.AddressBookModel;



@Controller
@RequestMapping("/AddressBook")
public class AddressBookController {

	
	@Autowired 
	AddressBookDataInterface bookservice;
	

	@GetMapping("/")
	public String DisplayBook(Model model) {
	
		List<AddressBookModel> contacts = bookservice.FindAllContacts();
		

		model.addAttribute("title", "Contacts");
		model.addAttribute("contacts", contacts);
		return "book";
	}
	
	@GetMapping("/CreateContactForm")
	public String ContactForm(Model model) {
		
		model.addAttribute("addressBookModel", new AddressBookModel());
		return "CreateContact";
	}
	
	
	@PostMapping("/doCreateContact")
	public String CreateContact(@Valid AddressBookModel addressBookModel, BindingResult bindingResult, Model model) {
		
		
		if (bindingResult.hasErrors())
		{
			model.addAttribute("title", "Create Contact Form");
			System.out.println("Test");
			return "CreateContact";
		}
		
		bookservice.create(addressBookModel);
		
		List<AddressBookModel> contacts = bookservice.FindAllContacts();
		
		
		model.addAttribute("contacts", contacts);
		System.out.println(contacts.size());
		
		return "book";
		
}
	
	@GetMapping("/editForm")
	public String displayEditForm(@RequestParam("id") int id, Model model)
	{
		
		AddressBookModel EditContact = bookservice.findById(id);
			System.out.println("EditContact info Incomming: " + EditContact.getId());
//			model.addAttribute("title", "Edit order");			
			model.addAttribute("addressBookModel", EditContact);		
		
		
		
		return "EditContact";
	}
	
	
	
		@PostMapping("/edit")
		public String edit(@RequestParam("id") int id, @Valid AddressBookModel addressBookModel, BindingResult bindingResult, Model model)
		{

			if (bindingResult.hasErrors())
			{
				System.out.println("we got errors");
				return "EditContact";
			}
			
			
			addressBookModel.setId(id);
			
			bookservice.update(addressBookModel);	
			
			List<AddressBookModel> contacts = bookservice.FindAllContacts();
			
			model.addAttribute("contacts", contacts);
			return "book";
		
				
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/delete")
	public String displayDeleteForm(@RequestParam("id") int id, Model model) 
	{	
		
		AddressBookModel DeleteContact = bookservice.findById(id);
			
		
			System.out.println(id);
			model.addAttribute("title", "Are you sure you want to delete?");
			model.addAttribute("contact", DeleteContact);
			
			System.out.println(id);
		
		
		return "DeleteContact2";
	}
	
	@PostMapping("/processdelete")
	public String deleteAlbum(AddressBookModel order, Model model)
	{	
		System.out.println("Index: " + order);
		
			bookservice.RemoveContact((int) order.getId());	
			System.out.println("Deleted Album is " + order);
			List<AddressBookModel> contacts = bookservice.FindAllContacts();
			
			model.addAttribute("title", "Home");
			model.addAttribute("contacts", contacts);
	
		return "book";
	}
	
	
	

}	
	

	

