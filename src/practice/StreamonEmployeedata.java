package practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

record EmployeeDto(
			String name,
			String department,
			int age,
			String gender,
			int salary) {}
	

public class StreamonEmployeedata {

	public static void main(String[] args) {
		EmployeeDto employee1 = new EmployeeDto("SRK","ECE",31,"Male",25000);
		EmployeeDto employee2 = new EmployeeDto("Salman","CS",44,"Male",50000);
		EmployeeDto employee3 = new EmployeeDto("Katrina","ECE",21,"Female",85000);
		EmployeeDto employee4 = new EmployeeDto("Kareena","CS",34,"Female",42000);
		EmployeeDto employee5 = new EmployeeDto("Hrithik","EEE",30,"Male",30000);
		EmployeeDto employee6 = new EmployeeDto("Aish","EEE",25,"Female",67000);
		
        List<EmployeeDto> list = new ArrayList<>();
        list.add(employee1);
        list.add(employee2);
        list.add(employee3);
        list.add(employee4);
        list.add(employee5);
        list.add(employee6);
        
        // 1.Find the names of all EmployeeDtos in the CS department, sorted by age in descending order.
        List<EmployeeDto> csSortedEmployeeDtos = list.stream()
        		.filter(s -> "CS".equals(s.department()))
        		.sorted(Comparator.comparingInt(EmployeeDto::age)
        		.reversed())
        		.collect(Collectors.toList());
        System.out.println("1.Find the names of all EmployeeDtos in the CS department, sorted by age in descending order \n"+csSortedEmployeeDtos);
        
		// 2. Group Employees by department and count how many Employees are in each department.
		Map<String, Long> departmentGroup = list.stream()
				.collect(Collectors.groupingBy(e -> e.department() , Collectors.counting()));
		System.out.println("2. Group Employees by department and count how many Employees are in each department : "+departmentGroup);
				
		// 3.Find the youngest female Employee.
		String youngestFemaleName = list.stream()
				.filter(s -> "Female".equals(s.gender()))
				.min(Comparator.comparingInt(EmployeeDto::age)).get().name();
		System.out.println("3.Find the youngest female Employee : "+youngestFemaleName);
		
		//5. Find the average age of EmployeeDtos in each department.
		Map<String, Double> averageAgeForDepartment = list.stream()
				.collect(Collectors.groupingBy(s -> s.department() , Collectors.averagingInt(s -> s.age())));
		System.out.println("5. Find the average age of EmployeeDtos in each department. "+averageAgeForDepartment);
		
		//6. Get a list of unique departments Employees belong to.
		List<String> uniqueDepartment = list.stream()
				.map(i -> i.department())
				.distinct()
				.toList();
		System.out.println("6. Get a list of unique departments Employees belong to "+uniqueDepartment);
		
        //8. Group employees by department, then within each department find the oldest employee
		Map<String, Optional<EmployeeDto>> departmentWiseGroup = list.stream()
				.collect(Collectors.groupingBy(i -> i.department() , Collectors.maxBy(Comparator.comparingInt(i -> i.age()))));
		System.out.println("8. Group employees by department, then within each department find the oldest employee \n"+departmentWiseGroup);
		
		//9. Build a map of gender with average age of employees sorted by average age descending
		Map<String,Double> mapOfGender = list.stream()
				.collect(Collectors.groupingBy(e -> e.gender() , Collectors.averagingDouble(i -> i.age())));
		System.out.println("9. Build a map of gender with average age of employees sorted by average age descending : "+mapOfGender);
		
		//10. For each department, find the youngest employee, but instead of returning the employee object, return only their name in uppercase.
//		Map<String,String> youngestEmployeeByAge = list.stream()
//				.collect(Collectors.groupingBy(e-> e.department() , Collectors.collectingAndThen(Collectors.minBy(Comparator.comparingInt(i -> i.age()),e -> e.g)))))

//		System.out.println("10. For each department, find the youngest employee, but instead of returning the employee object, return only their name in uppercase : "+youngestEmployeeByAge);
		
		//11. sort by salary in descending order
		List<EmployeeDto> sortBySalary = list.stream()
				.sorted(Comparator.comparingInt(EmployeeDto::salary).reversed())
				.collect(Collectors.toList());
		System.out.println("10. sort by salary in descending order: "+sortBySalary);
		
		//11.number of female and male workers
		Map<String, Long> maleFemale = list.stream()
				.collect(Collectors.groupingBy(EmployeeDto :: gender , Collectors.counting()));
		System.out.println("11. Number of female and male workers : "+maleFemale);
		
		
		
				
		

	}
	
	
	
	

}
