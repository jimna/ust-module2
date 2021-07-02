package assignment.training.task.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import assignment.training.model.Address;

public class AddressTest {

	Address address = new Address("Address1","Trivandrum","Kerala",695001);
	
	@Test
	void Addresstest() {
		String expected = "Address [addressLine=Address1, city=Trivandrum, state=Kerala, pincode=695001]";
		Assertions.assertEquals(expected, address.toString());	
	}
}
