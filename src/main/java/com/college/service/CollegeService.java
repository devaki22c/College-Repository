package com.college.service;

import java.util.List;
import java.util.Optional;

import com.college.dto.CollegeDto;

public interface CollegeService {
	public CollegeDto create(CollegeDto collegeDto);

	public CollegeDto update(CollegeDto collegeDto);

	public void deleteById(int id);

	public List<CollegeDto> findAll();

	public CollegeDto findById(int id);
}
