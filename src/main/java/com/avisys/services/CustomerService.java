package com.avisys.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avisys.cim.Customer;
import com.avisys.repository.CustomerRepository;

@Service
public class CustomerService {
     
	@Autowired
	CustomerRepository crepo;
	
	public List<Customer> getAllCustomer()
	{
		return  crepo.findAll();
	}
	
	public Customer getCustomer(String firstname,String lastname,String mobilenumber )
	{
		return crepo.getCustomer(firstname,lastname,mobilenumber);
	}
	
	 public Customer getCustomerByMobileNumber(String mobileNumber) {
	        return crepo.findByMobileNumber(mobileNumber);
	    }
	
	
	
}
