package features.java9;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.IntStream;

@SuppressWarnings("unused")
public class TestFeaturesMain {
	public static void main(String... args) {
		// Collection Factory method
		List<Integer> immutableList = List.of(1, 2, 3);
		Set<Integer> immutableSet = Set.of(1, 2, 3);
		Map<Integer, String> immutableMap = Map.of(1, "one", 2, "two", 3, "three");

		// improvement in try with resource--
		try (Resource resource = new Resource()) {
			System.out.println("Resource declare in try block");
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}

		// Java 9
		Resource resource = new Resource();
		try (resource) {
			System.out.println("Resource declare outside try block");
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}

		// New methods stream API--
		List<Integer> intList = Arrays.asList(1, 2, 3, 4, 7, 0, 5, 11, 12);

		intList.stream().takeWhile(e -> e < 4).forEach(System.out::println);
		// print 1,2 ,3

		intList.stream().dropWhile(e -> e < 4).forEach(System.out::println);
		// print 4, 7, 0, 5, 11, 12

		// imperative style code older version
		for (int count = 0; count < 10; count++) {
			System.out.println(count);
		}
		// java 9, more function style code
		IntStream.iterate(0, e -> e < 10, e -> e + 1).forEach(System.out::println);

		// method or() accept a supplier for default value.
		Optional<Integer> optional1 = intList.stream().filter(e -> e > 50).findFirst().or(() -> Optional.of(50));
		System.out.println(optional1); //

		// method ifPresentOrElse() accept a action if value present and a supplier for
		// default value.
		intList.stream().filter(e -> e > 50).findFirst().ifPresentOrElse(System.out::println, () -> Optional.of(50));

	}
}
