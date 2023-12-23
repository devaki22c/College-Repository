package com.college.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public class CollegeDto {

	//@NotNull(message="name should not be null")
	@Size(min=1,max=10, message="should have min 1 and max 10 char")
	private String name;
	
	@Size(min=1,max=10, message="should have min 1 and max 10 char")
	private String location;
	
	@Size(min=1,max=10, message="should have min 1 and max 10 char")
	private String grade;
	
	@Min(value=1,message="should have atleast 1")
	@Max(value =999)
	private int id;
	
	public CollegeDto() {
		
	}
	
	public CollegeDto(String name, String location, String grade, int id) {
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
