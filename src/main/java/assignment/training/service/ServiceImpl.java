package assignment.training.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;



import assignment.training.exception.PersonIsAlreadyPresent;
import assignment.training.exception.UserNotFoundException;
import assignment.training.model.Person;
import assignment.training.repository.PersonDao;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {
	
	@Autowired
	PersonDao dao;

	@Override
	public boolean insertPerson(Person person) throws PersonIsAlreadyPresent {
		if(dao.findById(person.getId()).isPresent()) {
			throw new PersonIsAlreadyPresent("person is already present");
		}
		dao.save(person);		
		return true;
	}
	public Person updatePerson( Person person) throws UserNotFoundException {
		Optional<Person> tempPerson=dao.findById(person.getId());
		if(! tempPerson.isPresent()) {
			throw new UserNotFoundException("person is not  present");
		}
		
		dao.deleteById(person.getId());
		return dao.save(person);
		
	}
	@Override
	public String deletePerson(Integer id) throws UserNotFoundException {
		Optional<Person> tempPerson=dao.findById(id);
		if(! tempPerson.isPresent()) {
			throw new UserNotFoundException("person is not  present");
		}
		
		 dao.deleteById(id);
		 return "success";
	}
	
	@Override
	public boolean findPerson(Integer id)  {
		if(dao.findById(id).isPresent()){
			return true;
		}
		
		return false;
	}
	@Override
	public void deleteAll() {
	dao.deleteAll();
		
	}
	@Override
	public List<Person> getAllPerson() {
		return dao.findAll();
	
	}

}
