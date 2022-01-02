package com.app.model;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonFormat;

//(fname, lname, dob, city, and mobile number).

@Entity
@Table(name="users")
public class User {
	
	@Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false)
	private String  firstName;
	@Column(nullable = false)
	private String lastName;
	
	//@JsonFormat(pattern="yyyy-MM-dd")
	//@Temporal(TemporalType.DATE)
	//private LocalDate dob;
//	@Column(nullable = false)
//	@JsonFormat(pattern="yyyy-MM-dd")
//	private Date dob;
	
	    @Column
	    private LocalDate dob;
	
	private String city;
	private String phone;
	
	
	
	public User() {
		super();
	}



	public User(long id, String firstName, String lastName, LocalDate dob, String city, String phone) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.city = city;
		this.phone = phone;
	}



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
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public LocalDate getDob() {
		return dob;
	}



	public void setDob(LocalDate dob) {
		this.dob = dob;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	

}
