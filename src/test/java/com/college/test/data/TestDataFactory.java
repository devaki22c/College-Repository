package com.college.test.data;

import com.college.dto.CollegeDto;

public class TestDataFactory {

	public static CollegeDto createSampleCollege() {
		CollegeDto collegeDto=new CollegeDto();
		collegeDto.setGrade("A");
		collegeDto.setId(123);
		collegeDto.setLocation("Hyd");
		collegeDto.setName("MLWEC");
		
		return collegeDto;
	}

}
