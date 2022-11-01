/**
 * 
 */
package com.daleel.assessment.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.daleel.assessment.api.model.Student;

/**
 * @author asifa
 *
 */
public interface StudentRepository extends MongoRepository<Student, String> {

	
}
