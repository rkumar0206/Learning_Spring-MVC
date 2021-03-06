package com.rohitthebest.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello") // this is a high level request mapping, now all the mappings will be like hello/name
public class HelloWorldController {

	// need a controller a method to show the initial form

	@RequestMapping("/showForm")
	public String showForm() {

		return "helloworld-form";
	}

	// need a controller method to process the HTML form

	@RequestMapping("/processForm")
	public String processForm() {

		return "helloworld";
	}

	// new controller method to read form data
	// add data to the model

	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {

		// read the request parameter from the HTML form
		String theName = request.getParameter("studentName");

		// convert the data to all caps
		theName = theName.toUpperCase();

		// create the message
		String result = "Yo! " + theName;

		// add message to the model
		model.addAttribute("message", result);

		return "helloworld";
	}

	/**
	 * Instead of HttpServletRequest we can make use of the annotation called
	 * @RequestParam for getting the parameter value directly into our arguments
	 */
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(
			@RequestParam("studentName") String theName,
			Model model) {

		// convert the data to all caps
		theName = theName.toUpperCase();

		// create the message
		String result = "Hey my friend from v3! " + theName;

		// add message to the model
		model.addAttribute("message", result);

		return "helloworld";
	}
	
}
