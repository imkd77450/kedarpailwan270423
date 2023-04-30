package com.avisys.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avisys.cim.MobileNumber;
import com.avisys.repository.MobileNumberRepository;

@Service
public class MobileNumberService {
	
	
	   @Autowired
	   MobileNumberRepository mrepo;

	    public void createMobileNumber(MobileNumber mobileNumber) {
	    	mrepo.save(mobileNumber);
	    }

	    public MobileNumber getMobileNumberById(Long mobileNoId)
	    {
	    	return mrepo.getMobileNumberById(mobileNoId);
	    }
	    
	    
	    public void deleteMobileNumber(MobileNumber mobileNumber) {
	    	mrepo.delete(mobileNumber);
	    }

	    

}
