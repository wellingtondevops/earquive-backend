package com.earchive.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.earchive.domain.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
	
	

}
