/**
 * 
 */
package com.daleel.assessment.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.daleel.assessment.api.model.Student;
import com.daleel.assessment.api.model.StudentQuery;
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
	public ResponseEntity<Student> addStudent(@Valid @RequestBody Student student) {
		
		Student newStudent = studentService.addStudent(student);
		
		return new ResponseEntity<>(newStudent, HttpStatus.OK);
	}
	
	@GetMapping("/students/paginated")
	public Page<Student> getStudentsPaginated(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "5") int size, @RequestParam(defaultValue = "firstName") String sort) {
		return studentService.getStudentsPaginated(page, size, sort);
	}
	
	@GetMapping("/students/filter")
	public List<Student> getStudentsFiltered(@RequestParam(required = false) String firstName,
			@RequestParam(required = false) String lastName, @RequestParam(required = false) String department) {

		return studentService.getStudentsByQuery(new StudentQuery(firstName, lastName, department));
	}
}
