package com.rohitthebest.springdemo.mvc;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Customer {

	private String firstName;
	
	// this is hibernate validation annotations and are used for validating our form
	@NotNull(message = "is required") 
	@Size(min = 1, max = 25, message = "is required") // the minimum size of lastName should be 1
	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastname) {
		this.lastName = lastname;
	}

}
