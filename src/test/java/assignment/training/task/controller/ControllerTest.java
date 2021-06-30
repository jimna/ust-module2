//package assignment.training.task.controller;
//
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import org.junit.Before;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import assignment.training.controller.Controller;
//import assignment.training.exception.PersonIsAlreadyPresent;
//import assignment.training.exception.UserNotFoundException;
//import assignment.training.model.Person;
//import assignment.training.service.ServiceImpl;
//
//public class ControllerTest {
//
//	private MockMvc mockmvc;
//	Person person = new Person();
//	
//	@Mock
//	private ServiceImpl serviceimpl;
//	
//	@InjectMocks
//	private Controller controller;
//	
//	@Before
//	public void setUp() {
//		MockitoAnnotations.initMocks(this);
//		mockmvc = MockMvcBuilders.standaloneSetup(controller).build();
//		person.setId(01);
//		person.setFirstName("John");
//		person.setLastName("Doe");
//	}
//	
//	@Test
//	public void insertPersonTest() throws PersonIsAlreadyPresent {
//		
//		Assertions.assertThrows(PersonIsAlreadyPresent.class, () -> {
//			Mockito.when(serviceimpl.insertPerson(person)).thenReturn(true);
//			mockMvc.perform(post("/insert").contentType(MediaType.PERSON_JSON).content(asJsonString(person))
//            .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print()));
//		});
//	}
//	
//	@Test
//	public void updatePersonTest() throws UserNotFoundException{
//		Assertions.assertThrows(NullPointerException.class, () -> {
//			person.setFirstName("Jim");
//			when(serviceimpl.updatePerson(person.getId(), any()))
//		})
//	}
//	
//}
