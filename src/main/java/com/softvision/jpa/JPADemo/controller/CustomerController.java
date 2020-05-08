package com.softvision.jpa.JPADemo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.softvision.jpa.JPADemo.entity.Customer;
import com.softvision.jpa.JPADemo.repository.CustomerRepository;
import com.softvision.jpa.JPADemo.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/api/softvision")
public class CustomerController {

	@Autowired
    private CustomerRepository customerRepository;
    
	//Add a customer
	 @PostMapping("/addCustomers")
	    public Customer createCustomer(@Valid @RequestBody Customer customer) {
	        return customerRepository.save(customer);
	    }
	 
	 //Get All customers
	 @GetMapping("/getAllCustomers")
	 @Transactional
	    public List <Customer> getAllCustomers() {
	        return customerRepository.findAll();
	    }
	 
	 //Get customer By Id
	 @GetMapping("/customers/{id}")
	 @Transactional
	    public ResponseEntity < Customer > getCustomerById(@PathVariable(value = "id") Long customerId)
	    throws ResourceNotFoundException {
		 Customer customer = customerRepository.findById(customerId)
	            .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + customerId));
	        return ResponseEntity.ok().body(customer);
	    }
	 
	 //Updating a customer
	 @PutMapping("/customers/{id}")
	 @Transactional
	    public ResponseEntity < Customer > updateCustomer(@PathVariable(value = "id") Long customerId,
	        @Valid @RequestBody Customer CustomerDetails) throws ResourceNotFoundException {
	        Customer customer = customerRepository.findById(customerId)
	            .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + customerId));

	        customer.setDeptId(CustomerDetails.getDeptId());
	        customer.setLastName(CustomerDetails.getLastName());
	        customer.setFirstName(CustomerDetails.getFirstName());
	        final Customer updatedCustomer = customerRepository.save(customer);
	        return ResponseEntity.ok(updatedCustomer);
	    }
	 
	 //Delete a Customer
	 @DeleteMapping("/customers/{id}")
	 @Transactional
	    public Map < String, Boolean > deleteCustomer(@PathVariable(value = "id") Long customerId)
	    throws ResourceNotFoundException {
		 Customer customer = customerRepository.findById(customerId)
	            .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + customerId));

		 customerRepository.delete(customer);
	        Map < String, Boolean > response = new HashMap < > ();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
}
