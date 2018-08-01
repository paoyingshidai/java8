package com.michael.java8.function.func;

import java.util.function.Supplier;

public class SupplierClient {

	public static void main(String[] args) {

		SupplierTask task = new SupplierTask(() -> "hello");
		System.out.println(task.get());
	}

}

class SupplierTask {

	Supplier<String> supplier;

	public SupplierTask(Supplier<String> supplier) {
		this.supplier = supplier;
	}

	public String get() {
		return supplier.get();
	}

}




