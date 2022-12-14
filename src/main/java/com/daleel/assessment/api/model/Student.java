/**
 * 
 */
package com.daleel.assessment.api.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author asifa
 *
 */
@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	/**
	 * Made it readonly so that it does not become part of the Rest API, because
	 * this is an Id field which should always be updated by the MongoDB
	 */
	@Id
	@JsonProperty(access = Access.READ_ONLY)
	String id;
	
	@NotBlank
	@Size(max = 50)
	String firstName;
	
	@NotBlank
	@Size(max = 50)
	String lastName;
	
	@NotBlank
	@Size(max = 30)
	String department;
}
