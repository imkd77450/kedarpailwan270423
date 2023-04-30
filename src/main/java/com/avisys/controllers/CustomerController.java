package com.avisys.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.avisys.cim.Customer;
import com.avisys.cim.CustomerDummy;
import com.avisys.cim.MobileNumber;
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
	  
	  
	  @PostMapping("/saveCustomer")
	  public ResponseEntity<?> saveCustomer(@RequestBody CustomerDummy c)
		{
		  try {
	            Customer customer = cservice.saveCustomer(c);
	            
	            return ResponseEntity.ok(customer);
	            
	        } 
		    catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	        }
			
		
		}
	  
	  
	  
	  @PutMapping("/{customerId}/mobile-numbers")
	    public void addMobileNumber(@PathVariable Long customerId, @RequestBody MobileNumber mobileNumber) {
	       
	           cservice.addMobileNumber(customerId, mobileNumber.getMobileNumber());
	           
	        
	    }

	    @DeleteMapping("/{customerId}/mobile-numbers/{mobileNumber}")
	    public void deleteMobileNumber( @PathVariable Long mobileNumber) {
	        
	         cservice.deleteMobileNumber( mobileNumber);
	            
	        
	    }
	  
	  
	  
	  
	  
	  
	  
	  @DeleteMapping("/delCust")
	  public Customer deleteCustomer(@RequestParam("mobileno") String mobileno)
	  {
		 return cservice.deleteCust(mobileno);
		  
	  }
	  
	  
	  
	  
	  

}
