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
import com.cfm.data.AddressBookDataInterface;
import com.cfm.models.AddressBookModel;


/*
 * Controller class for the AddressBook
 * This class is responsible for getting the logic of the application to the front end view Thymleaf
 * @Controller, @RequestMapping("/AddresBook")
 */
@Controller
@RequestMapping("/AddressBook")
public class AddressBookController {

	
	/*
	 * Autwire the DataInterface 
	 * Should be the Business Service
	 */

	@Autowired
	private AddressBookModelBusinessInterface bookservice;

	/*
	 * This is responsible for displaying the AddressBook.
	 * Create an object of the AddressBook contacts and return it
	 * @Param - , @GetMapping, Model 
	 * @Return model of contacts and book html
	 */
	@GetMapping("/")
	public String DisplayBook(Model model) {
	
		// List of contacts
		List<AddressBookModel> contacts = bookservice.FindAllContacts();
		
		// Passing in the model 
		model.addAttribute("contacts", contacts);
		
		return "book";
	}
	
	/*
	 * This is responsible for creating the form and establishing the model attribute for a new AddressBook contact
	 * @Param - @Getmapping, Model 
	 * @Return - a CreateContact.html and a new AddressBookModel
	 */
	@GetMapping("/CreateContactForm")
	public String ContactForm(Model model) {
		
		// model 
		model.addAttribute("addressBookModel", new AddressBookModel());
		
		// return html
		return "CreateContact";
	}
	
	
	
	/*
	 * Create a AddressBook Contact controller method
	 * Reference the bookservice create and return back the list once you return the book
	 * @Param - @Valid AddressBookModel addressBookModel, BindingResult bindingResult, Model model
	 * @Return- A created contact, book.html, and the list with it.
	 */
	@PostMapping("/doCreateContact")
	public String CreateContact(@Valid AddressBookModel addressBookModel, BindingResult bindingResult, Model model) {
		
		
		if (bindingResult.hasErrors())
		{
			model.addAttribute("title", "Create Contact Form");
			System.out.println("Test");
			return "CreateContact";
		}
		
		// create the book
		bookservice.create(addressBookModel);
		//  declare the list 
		List<AddressBookModel> contacts = bookservice.FindAllContacts();
		
		
		model.addAttribute("contacts", contacts);
		System.out.println(contacts.size());
		
		return "book";
		
}
	
	/*
	 * This is responsible for populating the Edit form, this is going to pass in a AddressBookModel object that finds the ID.
	 * Return the EditContact to the next page as well.
	 * @Param - Getmapping, RequestParam("id") Model
	 * @Return - a EditContact.html, and a EditContact object
	 */
	@GetMapping("/editForm")
	public String displayEditForm(@RequestParam("id") int id, Model model)
	{
		// establish a editContact Object = the the ID
		AddressBookModel EditContact = bookservice.FindById(id);
		System.out.println("EditContact info Incomming: " + EditContact.getId());
		model.addAttribute("title", "Edit order");			
		model.addAttribute("addressBookModel", EditContact);		
		
		
		
		return "EditContact";
	}
	
		/*
		 * This is responsible for actually processing the Edit of the contact. 
		 * This is retrieving information form the DisplayEditForm and I am forced to re initiate the ID as well
		 * I then Update the object and reference the addressBooKModel
		 * @Param @RequestParam("id") int id, @Valid AddressBookModel addressBookModel, BindingResult bindingResult, Model model
		 * @Return - an updated list of contacts and book.html
		 */
		@PostMapping("/edit")
		public String edit(@RequestParam("id") int id, @Valid AddressBookModel addressBookModel, BindingResult bindingResult, Model model)
		{

			if (bindingResult.hasErrors())
			{
				System.out.println("we got errors");
				return "EditContact";
			}
			
			// set the id
			addressBookModel.setId(id);
			// update 
			bookservice.update(addressBookModel);	
			// declare list
			List<AddressBookModel> contacts = bookservice.FindAllContacts();
			
			model.addAttribute("contacts", contacts);
			return "book";
		
				
	}
	
		/*
		 * This is responsible grabbing the ID of the specific object you intend to delete
		 * Create an AddressBookModel Object of the requested ID
		 * Pass that contact into the next page
		 * @Param - int id, Model 
		 */
	@GetMapping("/delete")
	public String displayDeleteForm(@RequestParam("id") int id, Model model) 
	{	
		// declare the object = to the ID of the requested delete
		AddressBookModel DeleteContact = bookservice.FindById(id);
			
		
			System.out.println(id);
			model.addAttribute("title", "Are you sure you want to delete?");
			model.addAttribute("contact", DeleteContact);
			
			System.out.println(id);
		
		
		return "DeleteContact2";
	}
	
	/*
	 * This method is responsible for actually deleting the requested album,
	 * In this method, call on the business service logic to remove the contact and then return back to the book.html
	 * I also reinstantiate the list
	 * @Param - Postmapping , AddressBookModel, Model
	 * @Return - book.html, a deleted Object
	 */
	@PostMapping("/processdelete")
	public String deleteAddressBook(AddressBookModel order, Model model)
	{	
		System.out.println("Index: " + order);
		
		// remove contact with casting it as int
			bookservice.RemoveContact((int) order.getId());	
			System.out.println("Deleted Album is " + order);
			// return the list
			List<AddressBookModel> contacts = bookservice.FindAllContacts();
			
			model.addAttribute("title", "Home");
			model.addAttribute("contacts", contacts);
	
		return "book";
	}
	
	
	

}	
	

	

