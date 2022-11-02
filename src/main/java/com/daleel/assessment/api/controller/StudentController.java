/**
 * 
 */
package com.daleel.assessment.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daleel.assessment.api.model.Student;
import com.daleel.assessment.api.service.StudentService;

/**
 * @author asifa
 *
 */
@RestController
@RequestMapping(value = "/api")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	
	@GetMapping("/students")
	public List<Student> getStudents() {
		return studentService.getAllStudents();
	}
	
	@PostMapping("/students")
	public ResponseEntity<Student> addStudent(@RequestBody Student student) {
		
		Student newStudent = studentService.addStudent(student);
		
		return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
	}
}
