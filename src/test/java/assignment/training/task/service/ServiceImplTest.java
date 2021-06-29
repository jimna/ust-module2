//package assignment.training.task.service;
//
//import static org.hamcrest.CoreMatchers.any;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.when;
//import com.ust.userservice.exception.UserNotFoundException;
//import java.nio.file.attribute.UserPrincipalNotFoundException;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import assignment.training.model.Address;
//import assignment.training.model.Person;
//import assignment.training.repository.PersonDao;
//import assignment.training.service.ServiceImpl;
//
//@ExtendWith(MockitoExtension.class)
//class ServiceImplTest {
//	
//	@Mock
//	private PersonDao persondao;
//	
//	@InjectMocks
//	private ServiceImpl serviceimpl;
//	
//	Person person = new Person();
//	Address address = new Address();
//	
//	@SuppressWarnings("deprecation")
//	@BeforeEach
//	public void SetUp() {
//		person = new Person();
//		address = new Address();
//	}
//	
//	@AfterEach
//	public void TearDown() {
//		person = null;
//		address = null;
//	}
//	
//	@Test
//	void testInsertPerson() throws UserNotFoundException {
//		person.setId(01);
//	}
//
//	@Test
//	void testUpdatePerson() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testDeletePerson() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testFindPerson() {
//		fail("Not yet implemented");
//	}
//
//}
