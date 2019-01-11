package com.earchive.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.earchive.domain.Company;
import com.earchive.domain.Container;
import com.earchive.dto.CompanyDTO;
import com.earchive.repositories.CompanyRepository;
import com.earchive.services.exceptions.DataIntegretyException;
import com.earchive.services.exceptions.ObjectNotFoundException;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepository repo;

	public Company search(Integer id) {

		Company obj = repo.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Company Not Found!! Id: " + id + ", Type:" + Container.class.getName());
		}
		return obj;
	}
	public Company insert(Company obj) {
		obj.setId(null);
		return repo.save(obj);

	}
	public Company update(Company obj) {
		search(obj.getId());

		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		search(id);
		try {
		repo.delete(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegretyException("It is not possible to delete a Company that has Active Containers");
			
		}
	}
	
	public List<Company> searchAll(){
		
		return repo.findAll();
	}
	
	public Page<Company> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
		
	}
	
	public Company fromDTO(CompanyDTO objDto) {
		
		return new Company(objDto.getId(), objDto.getName());
	}
	

}
