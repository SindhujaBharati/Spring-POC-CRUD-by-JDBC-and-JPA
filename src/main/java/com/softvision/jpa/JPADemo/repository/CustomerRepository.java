package com.softvision.jpa.JPADemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softvision.jpa.JPADemo.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	

}
