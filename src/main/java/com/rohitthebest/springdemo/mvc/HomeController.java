package com.rohitthebest.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // this inherits the @Component
public class HomeController {

	@RequestMapping("/")
	public String showPage() {
		
		// returning the view name, in the background 
		// Spring will actually call this view by adding 
		// the prefix and suffix i.e /WEB-INF/view/main-menu.jsp
		return "main-menu";
	}
}
