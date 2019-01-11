package com.earchive.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import com.earchive.domain.Warehouse;
import com.earchive.dto.WarehouseDTO;
import com.earchive.repositories.WarehouseRepository;
import com.earchive.services.exceptions.DataIntegretyException;
import com.earchive.services.exceptions.ObjectNotFoundException;

@Service
public class WarehouseService {

	@Autowired
	private WarehouseRepository repo;

	public Warehouse search(Integer id) {

		Warehouse obj = repo.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException(
					"Warehouse Not Found!! Id: " + id + ", Type:" + Warehouse.class.getName());
		}
		return obj;

	}

	public Warehouse insert(Warehouse obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Warehouse update(Warehouse obj) {
		search(obj.getId());
		return repo.save(obj);
	}

	public void delete(Integer id) {
		search(id);
		try {
			repo.delete(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegretyException("It is not possible to delete a Warehouse that has Active Containers");

		}
	}

	public List<Warehouse> searchAll() {

		return repo.findAll();
	}

	public Page<Warehouse> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);

	}

	public Warehouse fromDTO(WarehouseDTO objDto) {
		
		return new Warehouse(objDto.getId(), objDto.getName());
	}

}
