package com.sds.customer_service.dto;


import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


public class CustomerDTO {

	@NotBlank(message = "Name cannot be blank")
	@Size(min=2,max=100,message= "Name must be between 2 and 100 characters")
	private String name;
	
	@NotBlank(message="Contact number is required")
	@Pattern(regexp = "^[0-9]{10,15}$", message = "Contact number must be numeric and between 10 to 15 digits")
	private String contactNumber;
	@NotBlank(message="Email is required")
	@Email(message="Invalid email format")
	private String email;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
