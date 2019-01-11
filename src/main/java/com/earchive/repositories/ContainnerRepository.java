package com.earchive.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.earchive.domain.Container;

@Repository
public interface ContainnerRepository extends JpaRepository<Container, Integer> {
	
	

}
