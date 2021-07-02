package assignment.training;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import assignment.training.model.Person;
import assignment.training.service.Service;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@Slf4j
@EnableSwagger2
@EnableScheduling
public class AssignmentEquApplication {
	
	//private final Logger log = LoggerFactory.getLogger(AssignmentEquApplication.class);
	
	@Autowired
	Service service;

	public static void main(String[] args) {
		SpringApplication.run(AssignmentEquApplication.class, args);
	}
	@Scheduled(cron = "0 */2 * ? * *")
	public  void scheduledDelete() {
		
		log.info("delete started ");
		log.info("Deleting following records");
		List<Person> list = new ArrayList<>(service.getAllPerson());
		for(Person x:list) {
		log.info("Id: " + x.getId().toString() + ", First Name: " + x.getFirstName() + ", Last Name: " + x.getLastName());
		}
		service.deleteAll();
		
	}
	@Bean
	public ApiInfo apiInfo() {
		ApiInfoBuilder infoBuilder = new ApiInfoBuilder();
		
		infoBuilder.title("Person Details")
				.version("1.0")
				.license("CopyRight")
				.description("Person Details");
		
		return infoBuilder.build();
	}
	
	@Bean
	public Docket apiDocket(){
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
				.paths(PathSelectors.any()).build().pathMapping("/").apiInfo(apiInfo())
				.useDefaultResponseMessages(false);
	}

}
