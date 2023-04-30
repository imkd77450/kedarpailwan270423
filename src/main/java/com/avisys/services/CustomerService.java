package com.avisys.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avisys.cim.Customer;
import com.avisys.cim.CustomerDummy;
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
	
	 
	 public Customer saveCustomer(CustomerDummy c)throws Exception
		{
		    String mnumber = c.getMnumber();
			String fname   = c.getFname();
			String lname   = c.getLname();
			Customer customer = crepo.findByMobileNumber(mnumber);
			
			if(customer !=null)
			{
				throw new Exception(" Unable to create Customer. Mobile number already present.");
			}
			else {
				
				Customer cust= new Customer(fname,lname,mnumber);
				return crepo.save(cust);
			}
		 	
		}
	 
	 public Customer deleteCust(String mobileno)
	 {
		 return crepo.deletebyMobileno(mobileno);
	 }
	 
	 
	
}
