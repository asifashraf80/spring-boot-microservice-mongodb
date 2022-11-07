/**
 * 
 */
package com.daleel.assessment.api.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.daleel.assessment.api.model.Student;
import com.daleel.assessment.api.model.StudentQuery;

/**
 * @author asifa
 *
 */
public class StudentRepositoryCustomImpl implements StudentRepositoryCustom {
	@Autowired
	private MongoTemplate mongoTemplate;
	
	
	@Override
	public List<Student> getStudentsByQuery(StudentQuery studentQuery) {
		if (studentQuery == null) {
			return mongoTemplate.findAll(Student.class);
		}
		final Query mongoQuery = new Query();

		if (studentQuery.getFirstName() != null) {
			Criteria firstNameCriteria = Criteria.where("firstName").is(studentQuery.getFirstName());
			mongoQuery.addCriteria(firstNameCriteria);
		}

		if (studentQuery.getLastName() != null) {
			Criteria lastNameCriteria = Criteria.where("lastName").is(studentQuery.getLastName());
			mongoQuery.addCriteria(lastNameCriteria);
		}

		if (studentQuery.getDepartment() != null) {
			Criteria departmentCriteria = Criteria.where("department").is(studentQuery.getDepartment());
			mongoQuery.addCriteria(departmentCriteria);
		}

		return mongoTemplate.find(mongoQuery, Student.class);
	}

}
