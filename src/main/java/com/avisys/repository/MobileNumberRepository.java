package com.avisys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.avisys.cim.MobileNumber;

@Repository
public interface MobileNumberRepository extends JpaRepository<MobileNumber, Long>{

	@Query("select m from MobileNumber m where m.id=:mobileNoId")
	public MobileNumber getMobileNumberById(Long mobileNoId);
	
}
