/**
 * 
 */
package com.daleel.assessment.api.service;

import java.util.List;

import com.daleel.assessment.api.model.Student;

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
}
