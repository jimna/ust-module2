package assignment.training.service;

import org.springframework.beans.factory.annotation.Autowired;



import assignment.training.model.Person;
import assignment.training.repository.PersonDao;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {
	
	@Autowired
	PersonDao dao;

	@Override
	public boolean insertPerson(Person person) {
		dao.save(person);		
		return true;
	}
	public Person updatePerson(Integer id, Person person) {
		dao.save(person);
		return dao.findById(id).get();
		
	}
	@Override
	public void deletePerson(Integer id) {
		
		 dao.deleteById(id);
	}

}
