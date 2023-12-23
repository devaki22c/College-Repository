package com.college.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "college", schema = "student_schema")
public class College {

	@Column(name = "name")
	private String name;
	@Column(name = "location")
	private String location;
	@Column(name = "grade")
	private String grade;
	@Id
	@Column(name = "id")
	private int id;
	
	public College() {
		
	}

	public College(String name, String location, String grade, int id) {
		super();
		this.name = name;
		this.location = location;
		this.grade = grade;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
