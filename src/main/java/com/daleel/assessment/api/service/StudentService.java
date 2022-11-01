/**
 * 
 */
package com.daleel.assessment.api.service;

import java.util.List;

import com.daleel.assessment.api.model.Student;

/**
 * @author asifa
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
