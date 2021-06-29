package assignment.training.aspectj;


	import java.util.Date;

	
	import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;

import assignment.training.service.Service;

	/* Annotate this class with @Aspect and @Component */

	public class LoggingAspect {
		@Autowired
		Service service;

		@Before("execution(assignment.training.service.Service.deleteAll())")
		public void logBefore() {
			System.out.println("@Before:" + new Date());
			System.out.println("deleting the following items");
			System.out.println(service.getAllPerson().toString());
		}


		

}
