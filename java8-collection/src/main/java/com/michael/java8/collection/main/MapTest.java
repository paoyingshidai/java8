package com.michael.java8.collection.main;

import com.michael.java8.collection.bean.User;
import com.michael.java8.collection.dao.UserRepository;

public class MapTest {

	private UserRepository userRepository = new UserRepository();


	public User computeIfPresent() {
		User computeIfPresent = userRepository.getAllToMap().computeIfPresent(9L, (k, v) -> new User());
		return computeIfPresent;
	}


	public User merge() {
		User user = userRepository.getAllToMap().merge((long) 8, new User(), (value, newValue) -> new User());
		return user;
	}


	public static void main(String[] args) {
		MapTest mapTest = new MapTest();
		mapTest.userRepository.getAllToMap().forEach((k, v) -> System.out.println("key = " + k + ", value = " + v.toString()));
	}

}
