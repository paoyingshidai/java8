package com.michael.java8.collection.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

	private Long userId;
	
	private String username;
	
	private String password;
	
	private Integer age;
	
}
