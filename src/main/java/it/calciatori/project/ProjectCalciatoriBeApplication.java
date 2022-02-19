package it.calciatori.project;

import it.calciatori.project.model.Credentials;
import it.calciatori.project.service.CredentialsService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class ProjectCalciatoriBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectCalciatoriBeApplication.class, args);
	}

//	@Bean
//	CommandLineRunner run(CredentialsService credentialsService){
//		return args -> {
//
//			credentialsService.saveCredentialsAdmin(new Credentials(null, "admin", "admin", "ADMIN"));
//		};
//	}

}