package com.softvision.jpa.JPADemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * This is our model class and it corresponds to Customer table in database
 */
@Entity
@Table(name="CUSTOMER")
public class Customer {
	
	public Customer() {

    }
	
	public Customer(int id,String firstName, String lastName, int deptId) {
		super();
		this.id=id;
		this.firstName = firstName;
		LastName = lastName;
		this.deptId = deptId;
	}
	
	 public Customer(String firstName, String lastName, int deptId) {
		super();
		this.firstName = firstName;
		LastName = lastName;
		this.deptId = deptId;
	}


	@Id
	 @Column(name="Id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	 long id;
	 

	 @Column(name="First_name", nullable = false)
	 String firstName;
	 

	 @Column(name="Last_name")
	 String LastName;
	 

	 @Column(name="Dept_Id", nullable = false)
	 int deptId;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return LastName;
	}


	public void setLastName(String lastName) {
		LastName = lastName;
	}


	public int getDeptId() {
		return deptId;
	}


	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}


	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", LastName=" + LastName + ", deptId=" + deptId
				+ "]";
	}
	 
}
