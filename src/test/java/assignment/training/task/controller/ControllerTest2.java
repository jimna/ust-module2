package assignment.training.task.controller;

import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import com.google.gson.Gson;

import assignment.training.controller.Controller;
import assignment.training.model.Address;
import assignment.training.model.Person;
import assignment.training.service.Service;
import assignment.training.service.ServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest
class ControllerTest2 {

	@Autowired
	private MockMvc mock;

	@MockBean
	private ServiceImpl service;

	@InjectMocks
	private Controller controller;

	Person person;
	Address address = null;

	@BeforeEach
	public void setUp() {
		person = new Person(01,"John","Doe","01/01/2020",(List<Address>) address,"02/02/2020");

	}

	@Test
	public void insertPersonTest() throws Exception {
		when(service.insertPerson(person)).thenReturn(true);
		mock.perform(MockMvcRequestBuilders.post("/person/insert").contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(person))).andExpect(MockMvcResultMatchers.status().isExpectationFailed());
	}

	@Test
	public void updatePersonTest() throws Exception {
		when(service.updatePerson(person)).thenReturn(person);
		mock.perform(MockMvcRequestBuilders.put("/person/update/01").contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(person))).andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void deletePersonTest() throws Exception {
		when(service.deletePerson(person.getId())).thenReturn("success");
		mock.perform(MockMvcRequestBuilders.put("/person/delete/01").contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(person))).andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void findPersonTest() throws Exception {
		when(service.findPerson(person.getId())).thenReturn(true);
		mock.perform(MockMvcRequestBuilders.get("/person/01").contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(person))).andExpect(MockMvcResultMatchers.status().isOk());

	}
	
	
}