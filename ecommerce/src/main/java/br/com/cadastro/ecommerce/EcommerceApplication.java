package br.com.cadastro.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import configuration.SecurityConfig;

@Import({SecurityConfig.class})
@SpringBootApplication
//@ComponentScan(basePackageClasses = AdminController.class)
public class EcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}
	
}
