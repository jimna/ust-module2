package assignment.training.service;

import assignment.training.model.Person;

public interface Service {
	
	public boolean insertPerson(Person person);
	
	public Person updatePerson(Integer id, Person person);
	
	public void deletePerson(Integer id);
	
	

}
