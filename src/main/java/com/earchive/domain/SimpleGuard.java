package com.earchive.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.earchive.domain.enums.TypeContainer;

@Entity
public class SimpleGuard extends Container {	
	private static final long serialVersionUID = 1L;
	
	private String seal;
	private String reference;
	
	
	public SimpleGuard() {
		
		
	}


	public SimpleGuard(Integer id, String name_container, String volumeDescription, Date creation, TypeContainer type,
			Warehouse warehouse, Company company, String seal,String reference) {
		super(id, name_container, volumeDescription, creation, type, warehouse, company);
		this.seal = seal;
		this.reference=reference;
	}


	public String getSeal() {
		return seal;
	}


	public void setSeal(String seal) {
		this.seal = seal;
	}


	public String getReference() {
		return reference;
	}


	public void setReference(String reference) {
		this.reference = reference;
	}
	
	
	
	
	
	
	

}
