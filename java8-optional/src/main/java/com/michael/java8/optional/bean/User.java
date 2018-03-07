package com.michael.java8.optional.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.michael.java8.optional.interf.StaticMethod;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private String username;
	
	private String password;
	
	private Integer age;
	
	private Optional<List<Address>> addresses;
	
	public List<Address> getUserAddress() {
		
		return this.addresses.orElse(null);
	}
	
}
