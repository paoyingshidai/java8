package com.michael.java8.collection.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.michael.java8.collection.bean.User;

public class UserRepository {

	public User getOne() {
		return new User(1L, "username", "password", 23);
	}

	public Optional<User> getOneOptional() {

		return Optional.of(new User(1L, "username", "password", 23));
	}

	public List<User> getAll() {
		List<User> users = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			users.add(User.builder().userId((long)i).username("username"+i).password("password"+i).age(10+i).build());
		}
		return users;
	}


	public Map<Long, User> getAllToMap() {
		Map<Long, User> users = Optional.ofNullable(new HashMap<Long, User>()).get();
		for (int i = 0; i < 10; i++) {
			users.putIfAbsent((long)i, User.builder().userId((long)i).username("username"+i).password("password"+i).age(10+i).build());
		}
		return users;
	}

}
