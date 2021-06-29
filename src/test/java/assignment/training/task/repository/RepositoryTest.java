//package assignment.training.task.repository;
//
//import static org.junit.jupiter.api.Assertions.*;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.mockito.junit.jupiter.MockitoExtension;
//import com.google.common.base.Optional;
//import assignment.training.model.Address;
//import assignment.training.model.Person;
//import assignment.training.repository.PersonDao;
//
//@ExtendWith(MockitoExtension.class)
//@SpringBootTest
//
//public class RepositoryTest {
//
//	@Autowired
//	private PersonDao persondao;
//	
//	private Person person;
//	private Address address;
//	
//	@BeforeEach
//	public void setup() {
//		person = new Person();
//		address = new Address();
//	}
//	
//	@AfterEach
//	public void tearDown() {
//		person = null;
//		address = null;
//	}
//	
//	@Test
//	public void savePersonDetails() {
//		person.setId(01);
//		person.setFirstName("Firstname");
//		person.setLastName("LastName");
//		person.setDateOfBirth("01/01/2020");
//		person.setCreatedDate("02/02/2020");
//		address.setAddressLine("MyAddress");
//		address.setCity("Trivandrum");
//		address.setState("Kerala");
//		address.setPincode(695001);
//		person.setAddress(address);
//			
//		Person savePerson = persondao.save(person);
//		assertNotNull(savePerson);
//		//assertEquals(savePerson.getFirstName(), person.getFirstName() );	
//	}
//	
//	@Test
//	public void deletePersonById() {
//		person.setId(01);
//		person.setFirstName("FirstName");
//		Person fetchPerson = persondao.save(person);
//		persondao.deleteById(fetchPerson.getId());
//		java.util.Optional<Person> findById = persondao.findById(fetchPerson.getId());
//		assertEquals(java.util.Optional.empty(), findById);
//	}
//	
//	@Test
//	public void getPersonById() {
//		person.setId(02);
//		Person savePerson = persondao.save(person);
//		java.util.Optional<Person> findById = persondao.findById(person.getId());
//		assertEquals(02, findById.get().getId());
//	}
//}
