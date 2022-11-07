/**
 * 
 */
package com.daleel.assessment.api.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.daleel.assessment.api.model.Student;
import com.daleel.assessment.api.model.StudentQuery;

/**
 * @author asifa
 * Service interface. Controller will call the Service interface instead of calling the Repository directly. 
 * Any business logic should be written inside the Service implementation instead of inside the controller. 
 *
 */
public interface StudentService {
	
	/**
	 * Return list of all Students in the DB
	 * @return list of all Students
	 */
	public List<Student> getAllStudents();
	
	/**
	 * Create a new Student record.
	 * @param student
	 * @return
	 */
	public Student addStudent(Student student);
	
	/**
	 * 
	 * @param studentQuery
	 * @return
	 */
	public List<Student> getStudentsByQuery(StudentQuery studentQuery);
	
	/**
	 * 
	 * @param studentQuery
	 * @return
	 */
	public Page<Student> getStudentsPaginated(int page, int size, String sort);
}
