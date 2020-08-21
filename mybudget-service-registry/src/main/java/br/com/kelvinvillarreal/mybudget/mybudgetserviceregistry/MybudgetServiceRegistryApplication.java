package br.com.kelvinvillarreal.mybudget.mybudgetserviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MybudgetServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybudgetServiceRegistryApplication.class, args);
	}

}

