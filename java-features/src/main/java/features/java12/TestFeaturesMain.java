package features.java12;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestFeaturesMain {

	public static void main(String[] args) {
		double average = Stream.of(1, 4, 2, 7, 4, 6, 5)
	       .collect(Collectors.teeing(
	       Collectors.summingDouble(val -> val), //calculate the sum of input stream
	       Collectors.counting(), //calculate the count of input stream
	       (sum, n) -> sum / n));  //divide the sum by input count
		System.out.println(average);
		
		var stringVar = "MK Study Journal";
        System.out.println(stringVar.indent(5));  //add leading space "     MK Study Journal"
        BiFunction<String, String,String> stringConcat = (x, y) -> {
            return x + y;
        };
        BiFunction<Character, Character, Boolean> firstLatsCharCompareFunc = (x, y) -> {
            return  x.equals(y);
        };
        // transform method is used to transform the
        //String transformed result may or may not be string
        var newConcatStringVar = stringVar.transform(s -> stringConcat.apply(s,s));
        var firstLatsCharCompare = stringVar.transform(s -> firstLatsCharCompareFunc.apply(s.charAt(0),s.charAt(s.length()-1)));
        System.out.println(newConcatStringVar);
        System.out.println(firstLatsCharCompare);
        
        //Number format compaction--
        NumberFormat numberFormat = NumberFormat.getCompactNumberInstance(Locale.US,
                NumberFormat.Style.SHORT);
        String formattedString = numberFormat.format(25000L);
        System.out.println(formattedString);  //25K
	}

}
