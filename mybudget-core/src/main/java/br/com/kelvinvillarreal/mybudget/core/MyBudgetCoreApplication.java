package br.com.kelvinvillarreal.mybudget.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MyBudgetCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyBudgetCoreApplication.class, args);
	}

}
