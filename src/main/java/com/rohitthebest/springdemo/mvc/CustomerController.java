package com.rohitthebest.springdemo.mvc;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

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
