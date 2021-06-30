/*package assignment.training.task;

import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import assignment.training.model.Person;
import assignment.training.repository.PersonDao;
import assignment.training.service.ServiceImpl;

@SpringBootTest
public class Tests {
	
	@Autowired
	private ServiceImpl serviceimpl;
	
	@MockBean
	private PersonDao persondao;
	
	public void FindPersonTest() {
		when(persondao.findAll()).then(null)
	}
	
	public void getPersonByIdTest() {
		Integer id = 1;
		when(persondao.findById(id)).thenReturn(Stream.of(new Person(1, "firstName", "lastName", "01/01/2020", "Kerala", "02/02/2020")),collect(Collectors.toList());
)
	}
	
	
	
}
*/