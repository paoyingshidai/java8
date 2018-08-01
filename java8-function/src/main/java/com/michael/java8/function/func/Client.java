package com.michael.java8.function.func;

/**
 * 使用函数式编程规范的接口可以被 lamdar 表达式实例化
 * @author Michael
 *
 */
public class Client {
	public static void main(String[] args) {
		UserTask task = new UserTask(name -> {return "hello : " + name;}); // 或者可以省略 return
		System.out.println(task.sayHello());
	}
}

/**
 * 调用 function 接口
 * @author Michael
 *
 */
class UserTask {
	IUserService userService;
	public UserTask(IUserService userService) {
		this.userService = userService;
	}
	public String sayHello() {
		return userService.sayHello("Michael");
	}
}

/**
 * 参见 Function的规范，接口只能有一个抽象方法。
 * @author Michael
 *
 */
@FunctionalInterface
interface IUserService {
	String sayHello(String name);
}
