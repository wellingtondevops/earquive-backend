package com.earchive.dto;

import java.io.Serializable;
import java.util.Date;

import com.earchive.domain.enums.TypeContainer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeName;


@JsonTypeName("managedGuard")
public class ManagedContainerDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name_container;
	private String volumeDescription;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date creation;	
	private TypeContainer Integer;
	
	private Integer warehouseId;
	private Integer companyId;
	private Integer nambersRecords;
	
	
	
	
	
	public ManagedContainerDTO() {}





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





	public Integer getNambersRecords() {
		return nambersRecords;
	}





	public void setNambersRecords(Integer nambersRecords) {
		this.nambersRecords = nambersRecords;
	}





	public TypeContainer getInteger() {
		return Integer;
	}





	public void setInteger(TypeContainer integer) {
		Integer = integer;
	}
	
	






}