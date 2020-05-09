package com.softvision.jpa.JPADemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.softvision.jpa.JPADemo.JDBC.repository.CustomerJDBCRepository;
import com.softvision.jpa.JPADemo.entity.Customer;

@SpringBootApplication
public class JpaDemoApplication  {
	
	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}


}
