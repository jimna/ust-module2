package assignment.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import assignment.training.model.Person;
import assignment.training.service.Service;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api
@RequestMapping("/api")
public class Controller {
	@Autowired
	Service service;
	
	@Autowired
	public Controller(Service service){
		this.service=service;
		
	}
	
	@PostMapping("/insert")
	@ApiOperation(value = "Insert personal Data")
	public ResponseEntity<?> insertPerson(@RequestBody Person person){
		if(service.insertPerson(person)) {
			return new ResponseEntity<String>("Created",HttpStatus.OK);
		}
		return new ResponseEntity<String>("Failed",HttpStatus.EXPECTATION_FAILED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable() Integer id,Person person){
		return new ResponseEntity<Person>(service.updatePerson(id, person), HttpStatus.OK);
	}
	
	

}
