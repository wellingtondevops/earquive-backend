/**
 * 
 */
package com.earchive.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.earchive.domain.Warehouse;

public class WarehouseDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	@NotEmpty(message="Required field")
	@Length(min=5, max=20, message="Size must be between 5 and 20 Characters")
	private String name;
	
	public WarehouseDTO() {
		
	}
	
	public WarehouseDTO(Warehouse obj) {
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
