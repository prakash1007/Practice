package practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Occurences {
public static void main(String[] args) {
	String value = "caPgeminI";

	 Map<String,Long> occurrence=Arrays.stream(value.split(""))
			 .map(i -> i.toLowerCase())
			 .collect(Collectors.groupingBy(Function.identity() , Collectors.counting()))
			 .entrySet().stream().filter(i -> i.getValue()>=1)
			 .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
			 
	 System.out.println(occurrence);
	 //System.out.println(occurrence.entrySet().stream().filter(i -> i.getValue()>=2).findFirst().orElse(null));
}
}

class duplicates
{
	public static void main(String[] args) {
		List<Integer> nums = List.of(1, 2, 3, 2, 4, 3, 5);
		HashSet<Integer> seen = new HashSet<Integer>();
		List<Integer> result = nums.stream()
				.filter(i -> seen.add(i))
				.collect(Collectors.toList());
		System.out.println(result);

	}

}

class rev_word
{
	public static void main(String[] args) {
		String s = " welcome to the jungle ";
		String[] words=s.split("\\s+");
		Collections.reverse(Arrays.asList(words));
		String result=String.join(" ", words);
		System.out.println(result);
	}
}
