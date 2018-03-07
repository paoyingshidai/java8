package com.michael.java8.optional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.michael.java8.optional.bean.Address;
import com.michael.java8.optional.bean.User;

/**
 * 与传统的使用之间的比较
 * @author Michael
 *
 */
public class UsageCompare {

	public static void main(String[] args) {
		
		Optional<List<Address>> address = null;
		
		User user = new User("username", "password", 12, address);
//		User user = null;
		
		Optional<User> u = Optional.of(user);
		
		User user2 = Optional.ofNullable(user).orElse(user);
		User result = Optional.ofNullable(user).orElseGet( () -> user2);
		
		
		u.ifPresent((value) -> {System.out.println(value.getUsername());});
		
//		return user.map(u -> u.getOrders()).orElse(Collections.emptyList())
//
//				//上面避免了我们类似 Java 8 之前的做法
//				if(user.isPresent()) {
//				  return user.get().getOrders();
//				} else {
//				  return Collections.emptyList();
//				}
//		Optional<List<Address>> map = u.map(value -> value.getAddresses().orElse(Collections.emptyList()));
		
//		User user = .....
//				if(user != null) {
//				  String name = user.getUsername();
//				  if(name != null) {
//				    return name.toUpperCase();
//				  } else {
//				    return null;
//				  }
//				} else {
//				  return null;
//				}
		String upperUsername = u.map(v -> v.getUsername())
		 .map(n -> n.toUpperCase())
		 .orElse(null);
		System.out.println(upperUsername);
	
		
//		address.get().stream().filter(addr -> addr.getCity().length() == 1)
							;
		
	}
	
	
	
	
}
