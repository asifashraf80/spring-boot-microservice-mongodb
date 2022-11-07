/**
 * 
 */
package com.daleel.assessment.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.daleel.assessment.api.model.Student;
import com.daleel.assessment.api.model.StudentQuery;
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

	@Override
	public List<Student> getStudentsByQuery(StudentQuery studentQuery) {
		return studentRepository.getStudentsByQuery(studentQuery);
	}

	@Override
	public Page<Student> getStudentsPaginated(int page, int size, String sort) {
		return studentRepository.findAll(PageRequest.of(page, size, Sort.by(sort)));
		
	}

	
	
	
}
