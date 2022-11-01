/**
 * 
 */
package com.daleel.assessment.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;


/**
 * @author asifa
 *
 */
@Document
@Data
@Builder
public class Student {
	@Id
	String id;
	String firstName;
	String lastName;
	String department;
}
