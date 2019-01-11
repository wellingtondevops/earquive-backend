package com.earchive.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.earchive.domain.Warehouse;
import com.earchive.dto.WarehouseDTO;
import com.earchive.services.WarehouseService;
import com.earchive.services.exceptions.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/warehouses")
public class WarehouseResource {

	@Autowired
	private WarehouseService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Warehouse> find(@PathVariable Integer id) {

		Warehouse obj = service.search(id);
		if (obj == null) {
			throw new ObjectNotFoundException(
					"Warehouse Not Found!! Id: " + id + ", Type:" + Warehouse.class.getName());
		}
		return ResponseEntity.ok().body(obj);

	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody WarehouseDTO objDto) {
		Warehouse obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody WarehouseDTO objDto, @PathVariable Integer id) {
		Warehouse obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Warehouse> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();

	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<WarehouseDTO>> searchAll() {
		List<Warehouse> list = service.searchAll();
		List<WarehouseDTO> listDTO = list.stream().map(obj -> new WarehouseDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);

	}

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<WarehouseDTO>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<Warehouse> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<WarehouseDTO> listDTO = list.map(obj -> new WarehouseDTO(obj));
		return ResponseEntity.ok().body(listDTO);

	}

}
