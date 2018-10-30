package com.michael.java8.function.func;

import java.util.function.Consumer;


/**
 * void accept(T t);
 * Consumer 接口只接受参数，没有返回值
 *
 */
public class ConsumerClient {

	public static void main(String[] args) {

		ConsumerTask task = new ConsumerTask(name -> {System.out.println("hello : " + name);});
		task.sayHello();

		MyConsumer1 c1 = new MyConsumer1();
		MyConsumer2 c2 = new MyConsumer2();
		task.andThen(c1, c2);

	}
}

class ConsumerTask {

	Consumer<String> consumer;

	public ConsumerTask(Consumer<String> consumer) {
		this.consumer = consumer;
	}

	public void sayHello() {
		consumer.accept("Michael");
	}

	public void andThen(Consumer<String> c1, Consumer<String> c2) {
		c1.andThen(c2).accept("Michael");
	}
}


class MyConsumer1 implements Consumer<String> {
	@Override
	public void accept(String t) {
		System.out.println("MyConsumer1 " + t);
	}
}

class MyConsumer2 implements Consumer<String> {
	@Override
	public void accept(String t) {
		System.out.println("MyConsumer2 " + t);
	}
}
