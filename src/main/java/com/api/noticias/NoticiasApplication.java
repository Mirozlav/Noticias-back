package com.api.noticias;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = {"com.api.noticias.api","com.api.noticias.config","com.api.noticias.contracts","com.api.noticias.contracts.util",
		"com.api.noticias.model","com.api.noticias.repository","com.api.noticias.service","com.api.noticias.service.impl",
		"com.api.noticias.service.intf"})
@EnableAutoConfiguration
public class NoticiasApplication {

	public static void main(String[] args) {
		SpringApplication.run(NoticiasApplication.class, args);
	}

}
