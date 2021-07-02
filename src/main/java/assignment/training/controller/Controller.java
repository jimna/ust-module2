package assignment.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import assignment.training.exception.UserNotFoundException;
import assignment.training.model.Person;
import assignment.training.service.Service;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api
@RequestMapping("/person")
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
		try {
		if(service.insertPerson(person)) {
			return new ResponseEntity<String>("Created",HttpStatus.OK);
		}
		return new ResponseEntity<String>("Failed",HttpStatus.EXPECTATION_FAILED);
	}
		catch(Exception e){
			return new ResponseEntity<String>("Error "+e.getMessage()+" "+person.getFirstName() ,HttpStatus.OK);
		}
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@RequestBody Person person){
		try {
			service.updatePerson(person);
			return new ResponseEntity<String>("Updated", HttpStatus.OK);
		} catch (UserNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.OK);
		}
	}
	@PutMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable() Integer id){
		try {
			service.deletePerson(id);
		} catch (UserNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.OK);
		}
		return new ResponseEntity<String>("Successfully Deleted " + id, HttpStatus.OK);
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> findPerson(@PathVariable() Integer id){
		
		
		if(service.findPerson(id)) {
		return new ResponseEntity<String>("person already exist" + id , HttpStatus.OK);
	}
		else
			return new ResponseEntity<String>("person  is not present"+ id ,HttpStatus.OK);
	
	}


}
