package assignment.training.task.repository;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.jupiter.api.Assertions;

import assignment.training.model.Address;
import assignment.training.model.Person;
import assignment.training.repository.PersonDao;

@RunWith(SpringRunner.class)
@SpringBootTest
class RepositoryTest {

	@Autowired
	@MockBean
	private PersonDao persondao;
	
	private Person person;
	private Address address;
	
	@BeforeEach
	public void setup() {
		person = new Person();
		address = new Address();
	}
	
	@AfterEach
	public void tearDown() {
		person = null;
		address = null;
	}

	@Test
	void InsertPerson() {
		@SuppressWarnings("unchecked")
		Person person = new Person(01,"John","Doe","01/01/2020",null,"02/02/2020");
		Person fetchPerson = persondao.findById(01).get();
		Assertions.assertEquals(person.getId(), fetchPerson.getId());
	}
	

//	@Test
//	void UpdatePerson() {
//		person.setId(01);
//		person.setFirstName("Firstname");
//		person.setLastName("LastName");
//		person.setDateOfBirth("01/01/2020");
//		person.setCreatedDate("02/02/2020");
//		address.setAddressLine("MyAddress");
//		address.setCity("Trivandrum");
//		address.setState("Kerala");
//		address.setPincode(695001);
//		
//		persondao.save(person);
//		Person fetchPerson = persondao.findById(01).get();
//		fetchPerson.setFirstName("John");
//		fetchPerson.setLastName("Doe");
//		persondao.save(fetchPerson);
//		fetchPerson = persondao.findById(01).get();
//		Assertions.assertEquals("John", fetchPerson.getFirstName());
//	}
//	@Test
//	void DeletePersonById() {
//		Person fetchPerson = persondao.save(person);
//		persondao.deleteById(fetchPerson.getId());
//		java.util.Optional<Person> findById = persondao.findById(fetchPerson.getId());
//		assertEquals(java.util.Optional.empty(), findById);
//	}
//	@Test
//	void FindPerson() {
//		person.setId(01);
//		person.setFirstName("John");
//		person.setLastName("Doe");
//		person.setDateOfBirth("01/01/2020");
//		person.setCreatedDate("02/02/2020");
//		address.setAddressLine("MyAddress");
//		address.setCity("Trivandrum");
//		address.setState("Kerala");
//		address.setPincode(695001);
//		Person savePerson = persondao.save(person);
//		java.util.Optional<Person> findById = persondao.findById(person.getId());
//		assertEquals(01, findById.get().getId());
//	}

}
