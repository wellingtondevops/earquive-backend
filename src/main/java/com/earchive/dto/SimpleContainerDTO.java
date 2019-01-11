package com.earchive.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("SimpleGuard")
public class SimpleContainerDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name_container;
	private String volumeDescription;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date creation;	
	private String seal;
	private String reference;
	private Integer warehouseId;
	private Integer companyId;
	
	
	
	
	public SimpleContainerDTO() {}




	public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
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




	public Integer getWarehouseId() {
		return warehouseId;
	}




	public void setWarehouseId(Integer warehouseId) {
		this.warehouseId = warehouseId;
	}




	public Integer getCompanyId() {
		return companyId;
	}




	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	
	
	
	


}
