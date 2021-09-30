package com.rohitthebest.springdemo.mvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	
	// add an initBinder ... to convert trim input string
	// removing leading and trailing whitespace
	// resolve issue for our validation
	
	/**
	 * This will pre process every data which is coming to this controller 
	 * and if it is String and the String has whiteSpace in the starting 
	 * and ending it will just trim it, also as we
	 * have passed true into the StringTrimmerEditor as parameter,
	 * if the String contains only whiteSpaces then it will make it null
	 * and thus it will be catched by our validator
	 */
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {

		theModel.addAttribute("customer", new Customer());

		return "customer-form";
	}

	/**
	 * @Valid will start a validation process on the customer object and will put
	 *        the result into the BindingResult
	 * 
	 *        Note : the position on the BindingResult should be always after
	 *        the @Valid annotation.
	 */
	@RequestMapping("/processForm")
	public String processform(
			@Valid @ModelAttribute("customer") Customer customer,
			BindingResult bindingResult) {

		System.out.println("Last name : |" + customer.getLastName() + "|");
		
		if (bindingResult.hasErrors()) {
			
			return "customer-form";
		}else {
			
			return "customer-confirmation";
		}
		
	}

}
