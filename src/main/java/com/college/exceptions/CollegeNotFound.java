package com.college.exceptions;

@SuppressWarnings("serial")
public class CollegeNotFound extends RuntimeException {

	public CollegeNotFound(String message) {
		super(message);
	}
}
