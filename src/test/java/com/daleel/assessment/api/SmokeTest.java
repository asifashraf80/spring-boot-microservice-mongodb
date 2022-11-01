package com.daleel.assessment.api;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.daleel.assessment.api.controller.StudentController;

@SpringBootTest
public class SmokeTest {

	@Autowired
	private StudentController studentController;

	@Test
	public void contextLoads() throws Exception {
		assertThat(studentController).isNotNull();
	}
}