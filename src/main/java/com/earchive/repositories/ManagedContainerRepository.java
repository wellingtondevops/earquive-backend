package com.earchive.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.earchive.domain.Container;
import com.earchive.domain.ManagedGuard;

@Repository
public interface ManagedContainerRepository extends JpaRepository<ManagedGuard, Integer> {

	ManagedGuard save(Container obj);
	
	

}
