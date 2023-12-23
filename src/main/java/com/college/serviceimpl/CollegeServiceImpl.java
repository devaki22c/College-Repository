package com.college.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.domain.College;
import com.college.dto.CollegeDto;
import com.college.exceptions.CollegeNotFound;
import com.college.mapper.CollegeCommandMapper;
import com.college.mapper.CollegeQueryMapper;
import com.college.repository.CollegeRepository;
import com.college.service.CollegeService;

@Service
public class CollegeServiceImpl implements CollegeService {

	@Autowired
	CollegeRepository collegeRepository;
	@Autowired
	CollegeCommandMapper collegeCommandMapper;
	@Autowired
	CollegeQueryMapper collegeQueryMapper;

	@Override
	public CollegeDto create(CollegeDto collegeDto) {
		 College college=collegeRepository.save(collegeCommandMapper.MapToCollege(collegeDto));
		 return collegeQueryMapper.mapToCollegeDto(college);
	}

	@Override
	public CollegeDto update(CollegeDto collegeDto) {
		 College college=collegeRepository.save(collegeCommandMapper.MapToCollege(collegeDto));
		 return collegeQueryMapper.mapToCollegeDto(college);
	}

	@Override
	public void deleteById(int id) {
		collegeRepository.deleteById(id);
	}

	@Override
	public List<CollegeDto> findAll() {
		List<College> colleges=  collegeRepository.findAll();
		return collegeQueryMapper.mapToCollegeDtos(colleges);
	}

	@Override
	public CollegeDto findById(int id) {
		 College college= collegeRepository.findById(id)
				 .orElseThrow(()->new CollegeNotFound("Entity not found with id: " + id));
		 return collegeQueryMapper.mapToCollegeDto(college);
	}

}
