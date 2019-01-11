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

import com.earchive.domain.Container;
import com.earchive.dto.ContainerDTO;
import com.earchive.dto.SimpleContainerDTO;
import com.earchive.services.ContainerService;
import com.earchive.services.exceptions.ObjectNotFoundException;

@RestController
@RequestMapping(value="/containers")
public class ContainerResource {
	
	@Autowired
	private ContainerService service;
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Container> find(@PathVariable Integer id) {
		
		Container obj = service.search(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Container Not Found!! Id: "+ id 
					+ ", Type:" + Container.class.getName());
		}
		return ResponseEntity.ok().body(obj);
		
		
	}
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<ContainerDTO>> searchAll(){
		List<Container> list = service.searchAll();
		List<ContainerDTO> listDTO =list.stream().map(obj -> new ContainerDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
		
	}
	
	@RequestMapping(value="/page",method=RequestMethod.GET)
	public ResponseEntity<Page<ContainerDTO>> findPage(
			@ RequestParam(value="page", defaultValue="0")Integer page, 
			@ RequestParam(value="linesPerPage", defaultValue="24")Integer linesPerPage, 
			@ RequestParam(value="orderBy", defaultValue="warehouse")String orderBy, 
			@ RequestParam(value="direction", defaultValue="ASC")String direction){
		Page<Container> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<ContainerDTO> listDTO =list.map(obj -> new ContainerDTO(obj));
		return ResponseEntity.ok().body(listDTO);
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody SimpleContainerDTO objDto) {
		Container obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	
	
	

}
