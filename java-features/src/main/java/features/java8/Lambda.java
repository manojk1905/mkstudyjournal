package features.java8;

import java.util.function.Function;

public class Lambda {

	public static void main(String[] args) {

		Runnable java8Runner = () -> {
			System.out.println("I am running");
		};
		
		Function<Integer, Integer> addFunc = x -> x + 1;
		System.out.println(addFunc.apply(2)); // 3
	}
}
