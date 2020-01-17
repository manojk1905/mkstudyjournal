package features.java11;

import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class TestFeaturesMain {

	public static void main(String[] args) {
		IntStream.of(1, 2, 3, 5, 6, 7).filter((var i) -> i % 2 != 0).forEach(System.out::println);

		TimeUnit c = TimeUnit.DAYS;
		System.out.println(c.convert(Duration.ofHours(24))); // 1
		System.out.println(c.convert(Duration.ofHours(48))); // 2
		System.out.println(c.convert(Duration.ofHours(60))); // 2

		Optional<?> emptyOptional = Optional.empty();
		System.out.println(emptyOptional.isEmpty()); // true
		Optional<String> nonEmptyOptional = Optional.of("mk study journal");
		System.out.println(nonEmptyOptional.isEmpty()); // false
	}

}
