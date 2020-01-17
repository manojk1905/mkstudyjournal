package features.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GenericChange {

	public static void main(String[] args) {
		final List<Boolean> bools1 = Arrays.asList(true);
		final List<Character> string1 = bools1.stream().map(x -> x ? 'a': 'b')
		.collect (Collectors.toList());
		
		 List<String> list = Arrays.asList("1","2","3");
         list.forEach(str -> System.out.println(str));
	}

}
