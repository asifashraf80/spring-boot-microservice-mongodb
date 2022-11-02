package com.daleel.assessment.api;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.daleel.assessment.api.controller.StudentController;
import com.daleel.assessment.api.model.Student;
import com.daleel.assessment.api.service.StudentService;

@WebMvcTest(StudentController.class)
public class WebMockTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private StudentService service;

	@Test
	public void addValidStudent() throws Exception {
		Student student = Student.builder().firstName("asif").lastName("ashraf").department("IT").build();
		
//		when(service.addStudent(student)).thenReturn(student);
//		this.mockMvc.perform(post("/students")).andDo(print()).andExpect(status().isOk())
//				.andExpect(content().string(containsString("Hello, Mock")));
	}
}