package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Certificate 
{
	@Id
	private Integer id;
	private Integer year;
	
	//Default constructor
	public Certificate() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//parameterized constructor
	public Certificate(Integer id, Integer year) {
		super();
		this.id = id;
		this.year = year;
	}
	
	//getters and setters
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	//to string
	@Override
	public String toString() {
		return "Certificate [id=" + id + ", year=" + year + "]";
	}
	
	
	

}
