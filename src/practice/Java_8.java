package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java_8 {
	public static void main(String[] args) {
		System.out.println("Java 8");
	}
}

class Remove_duplicate
{ 
	public static void main(String[] args) {
		List<Integer>  duplicateNumbers = Arrays.asList(1, 2, 3, 2, 4, 3, 5, 1);
		
		HashSet<Integer> seen =new HashSet<Integer>();
		List<Integer> uniqueNumbers=duplicateNumbers.stream().filter(i->seen.add(i))
				.collect(Collectors.toList());
		System.out.println("Unique numbers "+uniqueNumbers);
		
	}
}

class Find_duplicate
{
	public static void main(String[] args) {
		List<Integer> duplicateNumbers = Arrays.asList(1, 2, 3, 2, 4, 3, 5, 1);
		
		HashSet<Integer> seen =new HashSet<Integer>();
		List<Integer> uniqueNumbers=duplicateNumbers.stream().filter(i->!seen.add(i))
				.collect(Collectors.toList());
		System.out.println("Find Duplicates "+uniqueNumbers);
		
	}
}

class Sort_Descending
{
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(11, 11, 1, 3, 5, 6, 5);
		List<Integer> sort=list.stream().distinct().sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());
		System.out.println("sorted in descending "+sort);
	}
}

class sortByLength
{
	public static void main(String[] args) {
		List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "HTML", "Kotlin", "C++", "COBOL", 
				"C"); 
		List<String> result=listOfStrings.stream().sorted(Comparator.comparing(String::length))
				.collect(Collectors.toList());
		System.out.println("Result"+result);
	}
}

class Reverse_decimal
{
	public static void main(String[] args) {
		List<Double> decimalList = Arrays.asList(12.45, 23.58, 17.13, 42.89, 33.78, 71.85, 56.98, 21.12); 
		List<Double> reverse=decimalList.stream().sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());
		System.out.println("Decimal in reverse order"+reverse);
	}
}

class even_number
{
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 10 );
		Boolean allEven=numbers.stream().allMatch(i->i%2==0);
		System.out.println("The given numbers are "+allEven);
	}
}

class AnytartsWithA
{
	public static void main(String[] args) {
		List<String> nameList = Arrays.asList("Banana", "Pineapple", "Cat", "Andrew"); 
		Boolean anyMatch=nameList.stream().anyMatch(i->i.charAt(0)=='A');
		System.out.println("Starts with A is "+anyMatch);
	}
}

class NUmberStartsWith1
{
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(10, 12, 20, null, 19, 30);
		List<Integer> startWith1 = numbers.stream()
				.filter(i->String.valueOf(i).startsWith("1"))
				.toList();
		System.out.println("Number starts with 1 are "+startWith1);
	}
}

class Palindrome
{ 
	public static void main(String[] args) {
		List<String> palindromeNames = Arrays.asList("Telugu", "Tamil", 
				"Malayalam","Noon","Racecar","Wow","Madam","Pen","Paper"); 
				List<String> findPalindromeStrings = palindromeNames.stream()
						.filter(s->{
							return s.toLowerCase().contentEquals(new StringBuilder(s.toLowerCase()).reverse());
						}).toList();
				System.out.println(findPalindromeStrings);
								
	}
}

class largest_word
{
	public static void main(String[] args) {
		List<String> words = Arrays.asList("cat", "elephant", "dog", "giraffe", "zebra");
		Optional<String> longestWords=words.stream()
				.max(Comparator.comparing(String::length));
		longestWords.ifPresent(word->System.out.println("The longest word is "+word));
	}
}

class practice
{
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(10,15,8,49,25,98,32); 
		List<Integer> result=list.stream()
				.map(i->i*i*i).filter(i->i>50).collect(Collectors.toList());
		System.out.println(result);
	}
}

class MergeUnsorted
{
	public static void main(String[] args) {
		  int[] a = new int[] { 4, 2, 7, 1 }; 
		  int[] b = new int[] { 8, 3, 9, 5 }; 
		  int[] c= Stream.concat(
				  Arrays.stream(a).boxed(),Arrays.stream(b).boxed())
				  .sorted()
				  .mapToInt(i->i)
				  .toArray();	
		  System.out.println(Arrays.toString(c)); 
	}
}

class TopThree
{
	public static void main(String[] args) {
		List<Integer> listOfIntegers = Arrays.asList(71, 18, 42, 21, 67, 32, 95, 
				14, 56, 87); 
		List<Integer> topThree= listOfIntegers.stream()
				.sorted(Comparator.reverseOrder())
				.limit(3)
				.toList();
		System.out.println("The maximium three elements are "+topThree);
	}
}

class ThirdHighest
{
	public static void main(String[] args) {
		List<Integer> listOfIntegers = Arrays.asList(71, 18, 42, 21, 67, 32, 95, 
				14, 56, 87); 
		List<Integer> thirdHighest=listOfIntegers.stream()
				.sorted(Comparator.reverseOrder())
				.skip(2)
				.limit(1)
				.collect(Collectors.toList());
		System.out.println("The Third Highest element is "+thirdHighest);
	}
}

class anaagram
{
	public static void main(String[] args) { 
		  String s1 = "RaceCar"; 
		  String s2 = "CarRace"; 
		 
		  s1 = Stream.of(s1.split(""))
				  .map(i->i.toUpperCase())
				  .sorted()
				  .collect(Collectors.joining());
		  s2 = Stream.of(s2.split(""))
				  .map(i->i.toUpperCase())
				  .sorted()
				  .collect(Collectors.joining());
		  if(s1.equals(s2))
		  {
			  System.out.println("The given words are anagram");
		  }
		  else
		  {
			  System.out.println("The given words are not an anagram");

		  }
		  
	}
}

class SumOfAllDigits
{
	public static void main(String[] args) {
			int i = 12345; 
			int s = String.valueOf(i)
					.chars()
					.sum();
			System.out.println(s);
	}
}

class CommonElement
{
	public static void main(String[] args) {
		List<Integer> list1 = Arrays.asList(71, 21, 34, 89, 56, 28); 
		List<Integer> list2 = Arrays.asList(12, 56, 17, 21, 94, 34); 

		list1.stream().filter(i->list2.contains(i)).forEach(System.out::println);
	}
}	

class ReverseEachString
{
	public static void main(String[] args) {
		String str = "Java Concept Of The Day"; 
		String result=Arrays.stream(str.split(" "))
				.map(i->new StringBuilder(i).reverse().toString())
				.collect(Collectors.joining(" ")); 
				
		System.out.println(result);
	}
}

class RevereseString
{
	public static void main(String[] args) {
		String str = "Java Concept Of The Day"; 
		List<String> words = Arrays.asList(str.trim().split("\\s+"));
        Collections.reverse(words);
        String result = String.join(" ", words);

        System.out.println(result); // Day The Of Concept Java
	}
}

class Occurence
{
	public static void main(String[] args) {
		List<String> list = Arrays.asList("java", "java","react","spring","java");
		Map<String, Long> map=list.stream()
				.collect(Collectors.groupingBy(
						Function.identity()
						,Collectors.counting()
						));
		System.out.println(map);
		
	}
}


 class UniqueElement { 
	 public static void main(String[] args) { 
	  List<String> sentences = List.of("java is cool", "cool code in java"); 
	  Set<String> words = sentences.stream()
			  .flatMap(s-> Arrays.stream(s.split(" ")))
			  .collect(Collectors.toSet());
	  System.out.println(words);
	 } 
} 

 class SingleList
 {
	 public static void main(String[] args) {
		 List<List<Integer>> nums = List.of(List.of(1, 2), List.of(3, 4)); 
		 List<Integer> singleList=nums.stream()
				 .flatMap(s->s.stream())
				 .collect(Collectors.toList());
		 System.out.println(singleList);
	}
 }
 
 
 class DistinctChar
 {
	 public static void main(String[] args) {
		 List<String> words = List.of("java", "scala"); 
		 List<String> distinctChar=words.stream()
				 .flatMap(s->Arrays.stream(s.split("")))
				 .distinct()
				 .collect(Collectors.toList());
		 System.out.println(distinctChar);
	} 
 }
 
 class LongestWords
 {
	 public static void main(String[] args) {
		 List<String> words = Arrays.asList("apple", "banana", "orange", 
				 "pineapple", "blueberry"); 
		int maxLength=words.stream()
				 .max((o1,o2) -> o1.length() - o2.length())
				 .get()
				 .length();
		List<String> LongestWords = words.stream()
				.filter(s -> s.length() == maxLength)
				.collect(Collectors.toList());
		System.out.println(LongestWords);
		 }
 }
 
 class Peek
 {
	 public static void main(String[] args) {
			List<Integer> list1 = Arrays.asList(1,12,3); 
			int result = list1.stream()
					.reduce(0,(a,b) -> a+b);
					
			System.out.println(result);
	 }
 }

 class duplicate
 {
	 public static void main(String[] args) {
		 Set<Integer> seen = new HashSet<Integer>();
		 List<Integer> numbers = Arrays.asList(10, 15, 8, 49, 25, 98, 32, 15, 8);
		 List<Integer> duplicate = numbers.stream()
				 .filter(i -> !seen.add(i))
				 .distinct()
				 .toList();
		 System.out.println(duplicate);
	}
 }
 
class Second_largest
{
	public static void main(String[] args) {
		List<Integer> num = Arrays.asList(1,2,3,4,15,25,4,65,12,11);
		int secondLargest = num.stream()
				.sorted(Comparator.reverseOrder())
				.skip(1)
				.findFirst()
				.orElse(null);
		System.out.println(secondLargest);
	}
}

class helll{

public static List<String> arrange(List<String> list) {
    Queue<String> males = new LinkedList<>();
    Queue<String> females = new LinkedList<>();

    for (String s : list) {
        if (s.equals("M")) males.add(s);
        else females.add(s);
    }

    List<String> result = new ArrayList<>();

    while (!males.isEmpty() || !females.isEmpty()) {
        if (!males.isEmpty()) result.add(males.poll());
        if (!females.isEmpty()) result.add(females.poll());
    }
    return result;
}
}