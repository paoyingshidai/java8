package com.michael.java8.collection.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.michael.java8.collection.bean.User;
import com.michael.java8.collection.dao.UserRepository;

public class UserTest {

	private UserRepository userRepository = new UserRepository();

	/**
	 * 可变聚合  参见 http://blog.csdn.net/u014082714/article/details/51423756
	 *
	 * 在列表进行处理的时候不需要拆箱封箱，避免性能损耗
	 *
	 * @return
	 */
	public List<String> getUsernames() {

		 List<String> collect = userRepository.getAll().stream()
					.filter(user -> user.getUserId() > 5L)
					.map((user) -> user.getUsername())
					.collect(Collectors.toList());

		 System.out.println(collect);
		return collect;
	}
	/**
	 * 第二种写法 并行Stream 利用多核进行处理，性能大大提升
	 * @return
	 */
	public List<String> getUsernames2() {
		List<String> collect = userRepository.getAll().parallelStream()
				.filter(user -> user.getUserId() > 5L)
				.map((user) -> user.getUsername())
				.collect(()-> new ArrayList<>(), (list, item) -> list.add(item), (list, list1) -> list.addAll(list1));
		System.out.println(collect);
		return collect;
	}

	/**
	 * 过滤、循环操作
	 * @return
	 */
	public List<User> setUserIdTo1() {
		List<User> users = userRepository.getAll();

		users.stream().filter(user -> user.getUserId() > 5)
						.forEach(user -> user.setUserId(1L));

//		Stream.generate(Math::random);
//		Stream.iterate(1, item -> item*10).limit(10).forEach(System.out::println);
		return users;
	}

	/**
	 * 求和
	 * @return
	 */
	public Long sum() {
		List<User> users = userRepository.getAll();
		return users.stream().mapToLong(user -> user.getUserId()).sum();
	}

	public Integer max() {
		List<User> users = userRepository.getAll();
		return users.stream().mapToInt(user -> user.getAge()).max().getAsInt();
	}

	/**
	 * 最大值
	 * @return
	 */
	public User maxUserByAge() {
		List<User> users = userRepository.getAll();
		return users.stream().max((a, b) -> a.getAge() - b.getAge()).orElse(new User());
	}

	/**
	 * 排序
	 * @return
	 */
	public List<User> sort() {
		List<User> users = userRepository.getAll();
		users.stream().sorted((a, b) -> (a.getAge() - b.getAge()));
		return users;
	}


	/**
	 * List to Map
	 * @param users
	 * @return
	 */
	public Map listToMap(List<User> users) {

		List<User> us = userRepository.getAll();
		return us.stream().collect(Collectors.toMap(m -> m.getUserId(), m -> m));
	}

	public static void main(String[] args) {

		UserTest userTest = new UserTest();

		userTest.getUsernames();

		System.out.println("求和         =  " + userTest.sum());

		System.out.println("求最大值   =  " + userTest.max());

		System.out.println("年龄最大的User = " + userTest.maxUserByAge());

		userTest.setUserIdTo1().forEach((user) -> {System.out.println(user.toString());});
		System.out.println();
		userTest.sort().forEach(System.out::println);

	}

}
