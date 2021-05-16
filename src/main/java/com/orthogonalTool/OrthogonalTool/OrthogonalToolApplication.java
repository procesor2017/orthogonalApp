package com.orthogonalTool.OrthogonalTool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com")
public class OrthogonalToolApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrthogonalToolApplication.class, args);
	}

}
