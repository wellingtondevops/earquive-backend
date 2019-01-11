package com.earchive.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.earchive.domain.enums.TypeContainer;

@Entity
public class ManagedGuard extends Container{
	private static final long serialVersionUID = 1L;
	
	private Integer nambersRecords;
	
	public ManagedGuard() {
		
	}

	public ManagedGuard(Integer id, String name_container, String volumeDescription, Date creation,
			TypeContainer type, Warehouse warehouse, Company company,  Integer namberRecords) {
		super(id, name_container, volumeDescription, creation, type, warehouse, company);
		this.nambersRecords=namberRecords;
	}

	public Integer getNambersRecords() {
		return nambersRecords;
	}

	public void setNambersRecords(Integer nambersRecords) {
		this.nambersRecords = nambersRecords;
	}
	
	
	
}
