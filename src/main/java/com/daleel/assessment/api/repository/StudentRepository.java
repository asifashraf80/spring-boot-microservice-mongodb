/**
 * 
 */
package com.daleel.assessment.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.daleel.assessment.api.model.Student;

/**
 * @author asifa
 * Student Data Repository based on the Spring Data Repository for MongoDB.
 */
public interface StudentRepository extends MongoRepository<Student, String> {

	
}
