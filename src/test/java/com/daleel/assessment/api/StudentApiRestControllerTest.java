package com.daleel.assessment.api;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.daleel.assessment.api.controller.StudentController;
import com.daleel.assessment.api.model.Student;
import com.daleel.assessment.api.service.StudentService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;

/**
 * Junit Test class to test all the scenarios for Student API.
 * @author muhammad.asif
 *
 */
@WebMvcTest(StudentController.class)
public class StudentApiRestControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private StudentService service;

	/**
	 * Test the POST API by adding a valid student record with all valid values for all the fields. It should be accepted with HTTP status code: 200
	 * 
	 */
	@Test
	public void testValidStudent() throws Exception {
		Student student = new Student(null, "asif", "ashraf", "IT");
		String studentId = "id-1";
		Student createdStudent = new Student(studentId, student.getFirstName(), student.getLastName(),
				student.getDepartment());

		when(service.addStudent(student)).thenReturn(createdStudent);



		String uri = "/api/students";
		
		String inputJson = mapToJson(student);

		MvcResult mvcResult = mockMvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		assertNotNull(content, "response json is null.");
	    Student returnedStudent = mapFromJson(content, Student.class);
	    assertNotNull(returnedStudent, "response json is invalid");
	    assertEquals(createdStudent.getFirstName(), returnedStudent.getFirstName());
	    assertEquals(createdStudent.getLastName(), returnedStudent.getLastName());
	    assertEquals(createdStudent.getDepartment(), returnedStudent.getDepartment());
	   
	}
	
	
	/**
	 * Test the POST API by adding an invalid student record having firstname as
	 * empty value. It should be rejected with HTTP bad request (400)
	 * 
	 * @throws Exception
	 */
	@Test
	public void testInvalidStudentEmptyValue() throws Exception {
		// add firstname as empty
		Student student = new Student(null, "", "ashraf", "IT");
		

		String uri = "/api/students";
		
		String inputJson = mapToJson(student);

		MvcResult mvcResult = mockMvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(400, status);
		
	   
	}
	
	/**
	 * Test the POST API by adding an invalid student record having firstname text
	 * size exceeds 50 characters. It should be rejected with HTTP bad request (400)
	 * 
	 * @throws Exception
	 */
	@Test
	public void testInvalidStudentFieldSizeExceed() throws Exception {
		// add firstname as empty
		Student student = new Student(null,
				"This a big text. This is a very big text. This is a huge text. More than 50 chars", "ashraf", "IT");

		String uri = "/api/students";

		String inputJson = mapToJson(student);

		MvcResult mvcResult = mockMvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(400, status);

	}

	
	
	/**
	 * Test the GET API by adding two students records using POST API. It should return the list of 2 records.
	 * @throws Exception
	 */
	@Test
	public void testGetAllStudents() throws Exception {
		
		String uri = "/api/students";
		Student student1 = new Student(null, "asif", "ashraf", "IT");
		Student student2 = new Student(null, "sajid", "khan", "Finance");
		
		MvcResult postResult = null;
		int status = 0;
		
		when(service.addStudent(student1)).thenReturn(student1);
		when(service.addStudent(student1)).thenReturn(student1);

		// Add Student1
		String inputJson = mapToJson(student1);

		
		postResult = mockMvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();
		
		status = postResult.getResponse().getStatus();
		assertEquals(200, status);
		
		
		// Add Student 2
		inputJson = mapToJson(student2);
		
		postResult = mockMvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();
		
		status = postResult.getResponse().getStatus();
		assertEquals(200, status);
		
		// Test the GET API

		List<Student> list = Stream.of(student1, student2).collect(Collectors.toList());
		when(service.getAllStudents()).thenReturn(list);
		
		MvcResult mvcGetResult = mockMvc.perform(
				MockMvcRequestBuilders.get(uri)).andReturn();

		status = mvcGetResult.getResponse().getStatus();
		
		assertEquals(200, status);
		
		String content = mvcGetResult.getResponse().getContentAsString();
		assertNotNull(content, "response json is null.");
	    Student [] returnedStudents = mapFromJson(content, Student[].class);
	    
	    assertEquals(2, returnedStudents.length);
		
		
	   
	}
	
	
	protected String mapToJson(Object obj) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(obj);
	}

	protected <T> T mapFromJson(String json, Class<T> clazz)
			throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(json, clazz);
	}
}