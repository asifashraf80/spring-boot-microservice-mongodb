package com.daleel.assessment.api;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.daleel.assessment.api.controller.StudentController;

@SpringBootTest
class StudentApiApplicationTests {

	@Autowired
	private StudentController studentController;
	
	@Test
	void contextLoads() {
		assertThat(studentController).isNotNull();
	}

}
