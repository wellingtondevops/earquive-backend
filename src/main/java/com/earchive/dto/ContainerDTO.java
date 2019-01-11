/**
 * 
 */
package com.earchive.dto;

import java.io.Serializable;
import java.util.Date;
import com.earchive.domain.Company;
import com.earchive.domain.Container;
import com.earchive.domain.Warehouse;
import com.earchive.domain.enums.TypeContainer;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ContainerDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String name_container;
	private String volumeDescription;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date creation;
	private TypeContainer type;

	
	private Warehouse warehouse;

	
	private Company company;

	public ContainerDTO() {
			

	}

	public ContainerDTO(Container obj) {
		super();
		
		name_container = obj.getName_container();
		volumeDescription = obj.getVolumeDescription();
		creation = obj.getcreation();
		type = obj.getType();
		warehouse = obj.getWarehouse();
		company = obj.getCompany();
		

	}

	public String getName_container() {
		return name_container;
	}

	public void setName_container(String name_container) {
		this.name_container = name_container;
	}

	public String getVolumeDescription() {
		return volumeDescription;
	}

	public void setVolumeDescription(String volumeDescription) {
		this.volumeDescription = volumeDescription;
	}

	public Date getcreation() {
		return creation;
	}

	public void setcreation(Date creation) {
		this.creation = creation;
	}

	public TypeContainer getType() {
		return type;
	}

	public void setType(TypeContainer type) {
		this.type = type;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}
