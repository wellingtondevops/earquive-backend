package com.earchive.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.earchive.domain.Company;
import com.earchive.domain.Container;
import com.earchive.domain.SimpleGuard;
import com.earchive.domain.Warehouse;
import com.earchive.domain.enums.TypeContainer;
import com.earchive.dto.SimpleContainerDTO;
import com.earchive.repositories.CompanyRepository;
import com.earchive.repositories.ContainnerRepository;
import com.earchive.repositories.WarehouseRepository;
import com.earchive.services.exceptions.ObjectNotFoundException;

@Service
public class ContainerService {
	
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private WarehouseRepository warehouseRepository;

	@Autowired
	private ContainnerRepository repo;
	
	

	public Container search(Integer id) {

		Container obj = repo.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException(
					"Container Not no Found! Id: " + id + ", Type:" + Container.class.getName());
		}
		return obj;

	}
	
	public Container insert(Container obj) {
		obj.setId(null);
		
		
		
		return repo.save(obj);

	}

	public List<Container> searchAll() {

		return repo.findAll();
	}

	public Page<Container> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);

	}
	
	public SimpleGuard fromDTO(SimpleContainerDTO objDto) {
		
		Warehouse ware = warehouseRepository.findOne(objDto.getWarehouseId());
		
		Company comp = companyRepository.findOne(objDto.getCompanyId());
		
		SimpleGuard sCont= new SimpleGuard(null, objDto.getName_container(), objDto.getVolumeDescription(), objDto.getcreation(), TypeContainer.SIMPLEGUARD, 
				ware, comp, objDto.getSeal(), objDto.getReference());
		
		
		return sCont;
		
		
	}
	
	
	
	
	
	


}