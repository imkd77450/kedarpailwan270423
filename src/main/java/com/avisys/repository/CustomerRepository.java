package com.avisys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.avisys.cim.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

	@Query("select c.firstName,c.lastName,c.mobileNumber from Customer c where c.firstName = ?1 and c.lastName = ?2 and c.mobileNumber=?3")
	public Customer getCustomer(String firstname,String lastname,String mobilenumber);
	
	@Query("select Customer c from Customer c where c.mobileNumber=:mobileNumber")
	public Customer findByMobileNumber(String mobileNumber);
	
	@Query("delete Customer c from Customer c where c.mobileno=:mobileno")
	public Customer deletebyMobileno(String mobileno);
	
	
	
	
}
