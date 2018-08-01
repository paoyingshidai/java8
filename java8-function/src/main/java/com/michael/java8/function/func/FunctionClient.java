package com.michael.java8.function.func;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * java8 函数式编程
 * @author Michael
 *
 */
public class FunctionClient {

	public static void main(String[] args) {

		FunctionTask task = new FunctionTask(name -> {return "hello : " + name;});
		// 同时 也可以显示的实现 Function 接口
//		FunctionTask task2 = new FunctionTask(new MyFunction());
		System.out.println(task.sayHello());

		MyFunction func1 = new MyFunction();
		MyFunction2 func2 = new MyFunction2();
		System.out.println(task.andThen(func1, func2));
	}

}

/**
 * 使用接口规范可以免除接口实现的麻烦，直接在使用的时候用 lamda 表达式进行实现
 * @author Michael
 *
 */
class FunctionTask {

	Function<String, String> func;

	public FunctionTask(Function<String, String> func) {
		this.func = func;
	}

	public String sayHello() {
		return func.apply("Michael");
	}

	public String andThen(Function<String, String> func1, Function<String, String> func2) {
		return func1.andThen(func2).apply("Michael");
	}
}

class MyFunction implements Function<String, String> {
	@Override
	public String apply(String t) {
		return "MyFunction Hello " + t;
	}
}

class MyFunction2 implements Function<String, String> {
	@Override
	public String apply(String t) {
		return "MyFunction2 Hello " + t;
	}
}

class MyBiFunciton implements BiFunction<String, String, String> {
	@Override
	public String apply(String t, String u) {
		return "hello " + t + " and "+ u ;
	}
}
