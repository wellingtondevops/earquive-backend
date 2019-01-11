/**
 * 
 */
package com.earchive.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.earchive.domain.Company;

public class CompanyDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	@NotEmpty(message="Required field!")
	@Length(min=4, max=40, message="Size must be between 4 and 40 Characters")
	
	private String name;
	
	public CompanyDTO() {
		
	}
	
	public CompanyDTO(Company obj) {
		id = obj.getId();
		name = obj.getName();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
