package features.java8;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class TestFeaturesMain {

	public static void main(String[] args) {
		// Run below code to Test Function Interface.
		FuncInterface funcInterface = (name) -> System.out.println("Welcome ! " + name);
		funcInterface.welcome("Manoj");

		// Biconsumer Function--
		BiConsumer<String, String> consumer = (a, b) -> {
			System.out.println(a + b);
		};
		consumer.accept("Welcome", " MK Study Journal");

		// Bi Function--
		BiFunction<String, String, String> biFunction = (a, b) -> {
			return a + b;
		};
		System.out.println(biFunction.apply("Welcome", " MK Study Journal"));

		// Binary Operator
		BinaryOperator<Integer> findMaxBinOperator = BinaryOperator.maxBy((a, b) -> (a > b) ? 1 : ((a == b) ? 0 : -1));
		System.out.println(findMaxBinOperator.apply(21, 17));

		//Predicate
		Predicate<Integer> pr = a -> (a > 10); // will check given number is greater than 10
		System.out.println(pr.test(9)); // false
		System.out.println(pr.test(13)); // true

		//BiPredicate
		BiPredicate<Integer, Integer> biPr = (a, b) -> (a > b);
		System.out.println(biPr.test(9, 13)); // false
		System.out.println(biPr.test(13, 9)); // true

		//UnaryOperator
		UnaryOperator<Integer> unaryOperatorSquare = a -> (a * a);
		System.out.println(unaryOperatorSquare.apply(10));

		//Supplier
		Supplier<Long> randomValue = () -> System.nanoTime();
		System.out.println(randomValue.get());

	}
}
