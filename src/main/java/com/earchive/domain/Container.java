package com.earchive.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.earchive.domain.enums.TypeContainer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@Inheritance(strategy=InheritanceType.JOINED)

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@type")
@Entity
public class Container implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name_container;
	private String volumeDescription;
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date creation;
	private TypeContainer type;
	
	@ManyToOne
	@JoinColumn(name="warehouse_id")
	private Warehouse warehouse;
	
	@ManyToOne
	@JoinColumn(name="company_id")
	private Company company;
	
	
	
	
	public Container() {
		
	}

	public Container(Integer id, String name_container, String volumeDescription, Date creation, TypeContainer type, Warehouse warehouse, Company company) {
		super();
		this.id = id;
		this.name_container = name_container;
		this.volumeDescription = volumeDescription;
		this.creation = creation;
		this.type = type;
		this.warehouse =  warehouse;
		this.company =  company;
		
		
	}

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

	public TypeContainer getType() {
		return type;
	}

	public void setType(TypeContainer type) {
		this.type = type;
	}



	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Container other = (Container) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
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
