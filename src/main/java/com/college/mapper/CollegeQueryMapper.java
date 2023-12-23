package com.college.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.college.domain.College;
import com.college.dto.CollegeDto;

@Component
public class CollegeQueryMapper {

	//Entity to dto
	public CollegeDto mapToCollegeDto(College college) {
		CollegeDto collegeDto=new CollegeDto();
		BeanUtils.copyProperties(college, collegeDto);
		return collegeDto;
	}
	public List<CollegeDto> mapToCollegeDtos(List<College> colleges){
	return	colleges.stream().map(college->mapToCollegeDto(college)).collect(Collectors.toList());
	}
}
