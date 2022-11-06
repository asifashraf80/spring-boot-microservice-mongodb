package com.daleel.assessment.api.model;

import lombok.Data;

@Data
public class StudentQuery {
	
	private final String firstName;
	
	private final String lastName;

	private final String department;
}
