package com.cg.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "student")
public class StudentEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer rollNumber;
	private String name;
	private String address;
	private double percentage;
	
	public StudentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public StudentEntity(Integer rollNumber, String name, String address, double percentage) {
		super();
		this.rollNumber = rollNumber;
		this.name = name;
		this.address = address;
		this.percentage = percentage;
	}
	
	public int getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(Integer rollNumber) {
		this.rollNumber = rollNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	
	
}
