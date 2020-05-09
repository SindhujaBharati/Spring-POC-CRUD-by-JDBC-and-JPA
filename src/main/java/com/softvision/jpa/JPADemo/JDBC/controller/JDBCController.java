package com.softvision.jpa.JPADemo.JDBC.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softvision.jpa.JPADemo.JDBC.repository.CustomerJDBCRepository;
import com.softvision.jpa.JPADemo.entity.Customer;
import com.softvision.jpa.JPADemo.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/api/softvision")
public class JDBCController {
	
	@Autowired
	private CustomerJDBCRepository customerJDBCRepository;

	//Add a customer
	@GetMapping("/addJDBCCustomers")
		    public Object createCustomer(@Valid @RequestBody Customer customer) {
		        return customerJDBCRepository.insert(new Customer(10,"Sindhuja", "Bharati", 1));
		    }
		 
		 //Get All customers
		 @GetMapping("/getAlljdbcCustomers")
		 @Transactional
		    public List <Customer> getAllCustomers() {
		        return customerJDBCRepository.findAll();
		    }
		 
		//Get customer By Id
		 @GetMapping("/jdbccustomers/{id}")
		 @Transactional
		    public Optional<Customer> getCustomerById(@PathVariable(value = "id") Long customerId)
		    throws ResourceNotFoundException {
			 	return customerJDBCRepository.findById(customerId);

		      
		    }
		 
		 //Updating a customer
		 @PutMapping("/jdbccustomers/{id}")
		 @Transactional
		    public int update(@PathVariable(value = "id") Long customerId,
		        @Valid @RequestBody Customer CustomerDetails) throws ResourceNotFoundException {
			 return customerJDBCRepository.update(CustomerDetails);
	
		    }
		 
		 //Delete a Customer
		 @DeleteMapping("/jdbccustomers/{id}")
		 @Transactional
		    public int deleteById(@PathVariable(value = "id") Long customerId)
		    throws ResourceNotFoundException {

			 return customerJDBCRepository.deleteById(customerId);

		    }
}