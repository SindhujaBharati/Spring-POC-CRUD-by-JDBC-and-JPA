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
public class JpaDemoApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
 
    @Autowired
    private CustomerJDBCRepository customerRepository;


	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Inserting -> {}", customerRepository.insert(new Customer(1,"Sindhuja", "Bharati", 1)));
        logger.info("Inserting -> {}", customerRepository.insert(new Customer(2,"Priyanka", "Patil", 2)));
        logger.info("Inserting -> {}", customerRepository.insert(new Customer(3,"Pooja", "Patil", 2)));
		
        
        logger.info("All users -> {}", customerRepository.findAll());
        
        logger.info("Employee id 1 -> {}", customerRepository.findById(1));
        
        logger.info("Update 2 -> {}", customerRepository.update(new Customer(2,"Priyanka", "Sharma", 3)));
        customerRepository.deleteById(3);
        
        logger.info("All users after deleting id 3-> {}", customerRepository.findAll());
        
	}

}
