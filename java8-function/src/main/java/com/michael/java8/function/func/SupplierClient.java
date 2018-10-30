package com.michael.java8.function.func;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.function.Supplier;

/**
 * 该接口在 builder 模式中十分有用，
 * 他是的我们在工厂模式中不需要指定具体的类型
 */
public class SupplierClient {

	public static void main(String[] args) {

		SupplierTask taskString = new SupplierTask(() -> new String("hello"));
		SupplierTask taskObject = new SupplierTask(() -> new Student("Michael", "廣東"));
		System.out.println(taskString.get());
		System.out.println(taskObject.get());
	}

}

class SupplierTask <T> {

	Supplier<T> supplier;

	public SupplierTask(Supplier<T> supplier) {
		this.supplier = supplier;
	}

	public T get() {
		return supplier.get();
	}

}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Student {
	private String name;
	private String address;
}


