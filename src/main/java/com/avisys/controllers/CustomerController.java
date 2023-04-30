package com.avisys.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.avisys.cim.Customer;
import com.avisys.cim.CustomerDummy;
import com.avisys.services.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService cservice;
	
	@GetMapping("/getAllCustomer")
	public List<Customer> getall()
	{
		return cservice.getAllCustomer();
	}
	
	@GetMapping("/getCustomer")
	public Customer getCustomer(@RequestParam("fname") String firstname,@RequestParam("lname") String lastname,@RequestParam("mnumber") String mobilenumber)
	{
		return cservice.getCustomer(firstname,lastname,mobilenumber);
	}
	
	
	  @GetMapping("/getByMobileNumber")
	    public Customer getCustomerByMobileNumber(@RequestParam("mobileNumber") String mobileNumber) {
	        return cservice.getCustomerByMobileNumber(mobileNumber);
	    }

}
