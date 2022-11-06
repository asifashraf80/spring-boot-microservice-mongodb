/**
 * 
 */
package com.daleel.assessment.api.repository;

import java.util.List;

import com.daleel.assessment.api.model.Student;
import com.daleel.assessment.api.model.StudentQuery;

/**
 * @author asifa
 * Student Data Repository based on the Spring Data Repository for MongoDB.
 */
public interface StudentRepositoryCustom {

	List<Student> getStudentsByQuery(StudentQuery query);
}
