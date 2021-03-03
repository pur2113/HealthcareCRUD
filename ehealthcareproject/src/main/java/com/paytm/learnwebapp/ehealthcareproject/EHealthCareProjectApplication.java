package com.paytm.learnwebapp.ehealthcareproject;

import org.springframework.boot.SpringApplication; 
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@ComponentScan(basePackages= {"com.paytm.learnwebapp"})
//@EnableJpaRepositories("com.paytm.learnwebapp.repository")
public class EHealthCareProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(EHealthCareProjectApplication.class, args);
	}

}
