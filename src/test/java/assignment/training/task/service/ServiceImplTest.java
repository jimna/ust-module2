package assignment.training.task.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyInt;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import assignment.training.exception.PersonIsAlreadyPresent;
import assignment.training.exception.UserNotFoundException;
import assignment.training.model.Person;
import assignment.training.repository.PersonDao;
import assignment.training.service.ServiceImpl;

@RunWith(MockitoJUnitRunner.class)
class ServiceImplTest {

	@Autowired
	private MockMvc mockMvc;

	@Mock
	private PersonDao persondao;

	@InjectMocks
	private ServiceImpl serviceimpl;

	private Person person, person1;
	private List<Person> personlist;
	private Optional optional;

	@SuppressWarnings("deprecation")
	@BeforeEach
	public void SetUp() {

		MockitoAnnotations.initMocks(this);

		person = new Person(01, "John", "Doe", "01/01/2020", null, "02/02/2020");
		person1 = new Person(02, "Jane", "Doe", "01/01/2020", null, "02/02/2020");
		optional = Optional.of(person);

	}

	@AfterEach
	public void TearDown() {
		person = null;
		person1 = null;
	}

	@Test
	void testInsertPerson() {
		when(persondao.save(any())).thenReturn(person);
		assertEquals(person, persondao.save(person));
		verify(persondao, times(1)).save(any());
	}

	@Test
	void testUpdatePerson() throws UserNotFoundException{
		
		assertThrows(UserNotFoundException.class, () -> {
			Mockito.when(persondao.findById(person.getId())).thenReturn(Optional.empty());
			serviceimpl.updatePerson(person);
		});

		
	}

	@Test
	void testDeletePerson() throws UserNotFoundException {

		Assertions.assertThrows(UserNotFoundException.class, () -> {
			Mockito.when(persondao.findById(person.getId())).thenReturn(Optional.empty());
			serviceimpl.deletePerson(person.getId());

		});
	}

	@Test
	void testFindPerson() throws UserNotFoundException {
		Mockito.when(persondao.findById(person.getId())).thenReturn(Optional.empty());

		assertEquals(false, serviceimpl.findPerson(person.getId()));

	}
}


