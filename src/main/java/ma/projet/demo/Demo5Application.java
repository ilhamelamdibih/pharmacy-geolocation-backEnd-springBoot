package ma.projet.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Demo5Application {
	//public static ApiService apiService;
	public static void main(String[] args) {
		SpringApplication.run(Demo5Application.class, args);
		//ConfigurableApplicationContext context = SpringApplication.run(Demo5Application.class, args);
		//apiService = context.getBean(ApiService.class);
	}
}
