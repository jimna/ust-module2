package assignment.training.service;

import java.util.List;

import assignment.training.exception.PersonIsAlreadyPresent;
import assignment.training.exception.UserNotFoundException;
import assignment.training.model.Person;

public interface Service {
	
	public boolean insertPerson(Person person) throws PersonIsAlreadyPresent;
	
	public Person updatePerson( Person person) throws UserNotFoundException;
	
	public String deletePerson(Integer id) throws UserNotFoundException;
	
	public boolean findPerson(Integer id) ;

	public void deleteAll();

	public List<Person> getAllPerson();
	
	

}
