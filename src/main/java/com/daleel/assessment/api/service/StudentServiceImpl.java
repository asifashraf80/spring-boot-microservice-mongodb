/**
 * 
 */
package com.daleel.assessment.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daleel.assessment.api.model.Student;
import com.daleel.assessment.api.repository.StudentRepository;

/**
 * @author asifa
 *
 */
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	
	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student addStudent(Student student) {
		
		return studentRepository.save(student);
	}
	
}
