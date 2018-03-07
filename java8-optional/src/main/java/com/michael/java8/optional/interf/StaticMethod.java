package com.michael.java8.optional.interf;

import java.util.function.Supplier;

public interface StaticMethod {

	static String create(Supplier<String> str) {
		return str.get();
	}
	
	
	
}
