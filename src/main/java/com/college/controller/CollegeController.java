package com.college.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.college.domain.College;
import com.college.dto.CollegeDto;
import com.college.serviceimpl.CollegeServiceImpl;

import jakarta.validation.Valid;
//controller class
@RestController
@RequestMapping("/api/college/v1")
public class CollegeController {
	@Autowired
	CollegeServiceImpl collegeServiceImpl;

	@PostMapping("/create")
	public CollegeDto create(@Valid @RequestBody CollegeDto collegeDto) {
		return collegeServiceImpl.create(collegeDto);
	}

	@PutMapping("/update")
	public CollegeDto update(@Valid @RequestBody CollegeDto collegeDto) {
		return collegeServiceImpl.update(collegeDto);
	}

	@DeleteMapping("/delete")
	public void delete(@RequestParam("id") int id) {
		collegeServiceImpl.deleteById(id);
	}

	@GetMapping("/findById")
	public CollegeDto findById(@RequestParam("id") int id) {
		return collegeServiceImpl.findById(id);
	}

	@GetMapping("/findAll")
	public List<CollegeDto> findAll() {
		return collegeServiceImpl.findAll();
	}

	/*
	 * @GetMapping("/findByFirstName") public List<Student>
	 * findByFirstName(@RequestParam("firstName") String firstName) { return
	 * collegeServiceImpl.findByFirstName(firstName); }
	 */
}
