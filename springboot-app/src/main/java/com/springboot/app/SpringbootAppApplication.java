package com.springboot.app;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.springboot.app.adapter.EmployeeAdapter;

@EnableWebMvc
@SpringBootApplication
public class SpringbootAppApplication {

	@Autowired
	EmployeeAdapter empAdapter;
	
	
	public static void main(String[] args){
		SpringApplication.run(SpringbootAppApplication.class, args);

	}

}
