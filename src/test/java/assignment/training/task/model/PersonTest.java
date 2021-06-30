package assignment.training.task.model;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import assignment.training.model.Address;
import assignment.training.model.Person;

public class PersonTest {

	Address address = null;
	@SuppressWarnings("unchecked")
	Person person = new Person(01,"John","Doe","01/01/2020",(List<Address>) address,"02/02/2020");
	
	@Test
	void Persontest() {
		String expected = "Person [id=1, firstName=John, lastName=Doe, dateOfBirth=01/01/2020, address=null, createdDate=02/02/2020]";
	Assertions.assertEquals(expected, person.toString());	
	}
}
