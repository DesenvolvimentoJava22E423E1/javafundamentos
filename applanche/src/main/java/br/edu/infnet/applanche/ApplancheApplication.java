package br.edu.infnet.applanche;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApplancheApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApplancheApplication.class, args);
	}

}
