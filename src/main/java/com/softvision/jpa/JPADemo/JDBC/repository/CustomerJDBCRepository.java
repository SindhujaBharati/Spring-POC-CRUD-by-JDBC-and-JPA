package com.softvision.jpa.JPADemo.JDBC.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.softvision.jpa.JPADemo.entity.Customer;

@Repository
public class CustomerJDBCRepository {
	@Autowired
    JdbcTemplate jdbcTemplate;

    class CustomerRowMapper implements RowMapper < Customer > {
        @Override
        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        	Customer customer = new Customer();
        	customer.setId(rs.getLong("Id"));
        	customer.setFirstName(rs.getString("First_name"));
        	customer.setLastName(rs.getString("Last_name"));
        	customer.setDeptId(rs.getInt("Dept_Id"));
            return customer;
        }
	
    }

    //Adding customer
	public Object insert(Customer customer) {
		 return jdbcTemplate.update("insert into customer (Id,First_name, Last_name, Dept_Id) " + "values(?,?, ?, ?)",
	                new Object[] {
	                		customer.getId(),customer.getFirstName(), customer.getLastName(), customer.getDeptId()
	                });
	}

	//Get All customer
	public List < Customer > findAll() {
        return jdbcTemplate.query("select * from customer", new CustomerRowMapper());
    }

	//Find customer By Id
    public Optional < Customer > findById(long id) {
        return Optional.of(jdbcTemplate.queryForObject("select * from customer where id=?", new Object[] {
                id
            },
            new BeanPropertyRowMapper < Customer > (Customer.class)));
    }
    
    //Update Customer
    public int update(Customer customer) {
        return jdbcTemplate.update("update customer " + " set First_name = ?, Last_name = ?, Dept_Id = ? " + " where Id = ?",
            new Object[] {
            		customer.getFirstName(), customer.getLastName(), customer.getDeptId(), customer.getId()
            });
    }
    
    //Deleting a Customer   
    public int deleteById(long id) {
        return jdbcTemplate.update("delete from customer where id=?", new Object[] {
            id
        });
    }
}
