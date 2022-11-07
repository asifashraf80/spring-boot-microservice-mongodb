package com.daleel.assessment.api.repository;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.daleel.assessment.api.model.Student;
import com.daleel.assessment.api.model.StudentQuery;

@DataMongoTest
@ExtendWith(SpringExtension.class)
class StudentRepositoryIntegrationTest {
	
	@Autowired
	StudentRepository studentRepository;
	
    @DisplayName("Test custom query method")
    @Test
    void testStudentQuery(@Autowired MongoTemplate mongoTemplate) {
        // create test data with two students
        Student student1 = new Student(null, "asif", "ashraf", "IT");
        Student student2 = new Student(null, "sajid", "khan", "finance");
        studentRepository.save(student1);
        studentRepository.save(student2);
        
        // verify if the records are stored successfully
        
        assertEquals(2, studentRepository.findAll().size());
        
        // filter the student by firstname
        StudentQuery singleCriteriaQuery = new StudentQuery("asif", null, null);
        List<Student> singleCriteriaResult = studentRepository.getStudentsByQuery(singleCriteriaQuery);
      
        // then
         assertEquals(1, singleCriteriaResult.size());
  
         // filter the student by firstname and department
         StudentQuery multipleCriteriaQuery = new StudentQuery("asif", null, "IT");
         List<Student> multipleCriteriaQueryResult = studentRepository.getStudentsByQuery(multipleCriteriaQuery);
       
         // then
          assertEquals(1, multipleCriteriaQueryResult.size());
          
        // filter by firstname and lastname
        StudentQuery notFoundQuery = new StudentQuery("asif", "khan", null);
        List<Student> students2 = studentRepository.getStudentsByQuery(notFoundQuery);
      
        //assertFalse(students.isEmpty(), "Query result should not be empty");
        assertEquals(0, students2.size());
    }
}