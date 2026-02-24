package practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

class City {
	String name;
	int population;

	City(String name, int population) {
		this.name = name;
		this.population = population;
	}

	public String getName() {
		return name;
	}

	public int getPopulation() {
		return population;
	}

	@Override
	public String toString() {
		return name + "(" + population + ")";
	}

}

public class StreamsOnCityData {

	public static void main(String[] args) {
		List<City> cities = Arrays.asList(
				new City("Delhi", 12000), 
				new City("Mumbai", 800000),
				new City("Bangalore", 450000),
				new City("Hyderabad", 1200000), 
				new City("Chennai", 60000));

		// 1. City with the second highest population
		Optional<City> secondHighest = cities.stream().
				sorted(Comparator.comparingInt(City::getPopulation).reversed())
				.skip(1)
				.findFirst();
		System.out.println("1. City with the second highest population : "+secondHighest.orElseGet(null));
		
        // 2. Group by first character of name, then max population in each group
        Map<Character, City> maxByInitial = cities.stream()
        		.collect(Collectors.groupingBy(i -> i.getName().charAt(0) , 
        				Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(i -> i.population)),
        				Optional::get 
        				)
        			));
        System.out.println("2. Group by first character of name, then max population in each group : \n"+maxByInitial);
        
        // 3. Average population of top 3 most populated cities
        double avgTop3 = cities.stream()
        		.sorted(Comparator.comparingInt(City::getPopulation).reversed())
        		.limit(3)
        		.collect(Collectors.averagingInt(City::getPopulation));
        System.out.println("3. Average population of top 3 most populated cities : "+avgTop3);
        

	}

}
