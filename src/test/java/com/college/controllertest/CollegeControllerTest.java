package com.college.controllertest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.college.controller.CollegeController;
import com.college.domain.College;
import com.college.dto.CollegeDto;
import com.college.serviceimpl.CollegeServiceImpl;
import com.college.test.data.TestDataFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureWebMvc
public class CollegeControllerTest {

	private MockMvc mockMvc;

	@InjectMocks
	CollegeController collegeController;

	@Mock
	CollegeServiceImpl collegeServiceImpl;

	CollegeDto collegeDto = new CollegeDto();

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(collegeController).build();
		collegeDto = TestDataFactory.createSampleCollege();
	}

	//obj to json
	String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Test
	void testCreateCollege() throws Exception {
		doReturn(collegeDto).when(collegeServiceImpl).create(any(CollegeDto.class));

		mockMvc.perform(post("/api/college/v1/create").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(collegeDto))).andExpect(status().isOk());

		verify(collegeServiceImpl).create(any(CollegeDto.class));
	}

	@Test
	void testUpdateCollege() throws Exception {
		doReturn(collegeDto).when(collegeServiceImpl).update(any(CollegeDto.class));
		collegeDto.setName("Geethams");
		mockMvc.perform(
				put("/api/college/v1/update").contentType(MediaType.APPLICATION_JSON).content(asJsonString(collegeDto)))
				.andExpect(status().isOk());
		verify(collegeServiceImpl).update(any(CollegeDto.class));
	}

	/*
	 * @Test public void findById() throws Exception {
	 * when(collegeServiceImpl.findById(123)).thenReturn(collegeDto); this.mockMvc
	 * .perform(get("/api/college/v1/findById", 123)
	 * .contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.
	 * APPLICATION_JSON_VALUE))
	 * .andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.id").
	 * exists()); }
	 */
}
