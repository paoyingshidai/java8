package com.michael.java8.function.func;

/**
 * 使用函数式编程规范的接口可以被 lamdar 表达式实例化
 * @author Michael
 *
 */
public class Client {
	public static void main(String[] args) {
		UserTask task = new UserTask((name, name2) -> {return "hello : " + name + " and " + name2;}); // 或者可以省略 return
		System.out.println(task.sayHello("Micahel", "KorBe"));
	}
}

/**
 * 调用 function 接口
 * @author Michael
 *
 * @FunctionalInterface 注解比较宽松，没有固定的入参数量限定和返回结果限定
 *
 */
class UserTask {
	IUserService userService;
	public UserTask(IUserService userService) {
		this.userService = userService;
	}
	public String sayHello(String name1, String name2) {
		return userService.sayHello(name1, name2);
	}
}

/**
 * 参见 Function的规范，接口只能有一个抽象方法。
 * @author Michael
 *
 */
@FunctionalInterface
interface IUserService {
	String sayHello(String name, String name2);
}
