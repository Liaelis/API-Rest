package br.ufsm.leafstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EntityScan(basePackages = "br.ufsm")
@ComponentScan(basePackages = "br.ufsm")
@EnableJpaRepositories(basePackages = "br.ufsm")
@SpringBootApplication
public class WebServiceLeafStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebServiceLeafStoreApplication.class, args);
	}
	

}
