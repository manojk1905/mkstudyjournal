package features.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapUses {

	public static void main(String[] args) {
		List<String> list1 = Arrays.asList("Hello", "Friends");
		List<String> list2 = Arrays.asList("Welcome", "in");
		List<String> list3 = Arrays.asList("MK", "Study", "Journal");
		
		// map will transform string in a list to uppercase.
		List<String> list1Upper = list1.stream().map(String::toUpperCase).collect(Collectors.toList());
		System.out.println(" map : " + list1Upper);
		List<List<String>> listOfLists = Arrays.asList(list1, list2, list3);
		System.out.println("Before : " + listOfLists);
		
		// flat map is used to transform the list of list
		List<String> flatList = listOfLists.stream()
				.flatMap(list -> list.stream())
				.collect(Collectors.toList());
		System.out.println("After  : " + flatList);
	}

}
