package com.college.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.college.domain.College;
import com.college.dto.CollegeDto;

@Component
public class CollegeCommandMapper {
	
	//Dto to Entity
	public College MapToCollege(CollegeDto CollegeDto) {
		College college=new College();
		BeanUtils.copyProperties(CollegeDto, college);
		return college;
	}
	
	
}
