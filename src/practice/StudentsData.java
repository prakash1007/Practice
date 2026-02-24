package practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

 class Student {
	String firstName, lastName, city, department;
	double grade;
	int age;
	public Student(String firstName, String lastName, String city, double grade, int age, String department) {
	    this.firstName = firstName;
	    this.lastName = lastName;
	    this.city = city;
	    this.grade = grade;
	    this.age = age;
	    this.department = department;
	}
	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", city=" + city + ", department="
				+ department + ", grade=" + grade + ", age=" + age + "]";
	}
}

 public class StudentsData {
    public static void main(String[] args) {

        List<Student> student = Arrays.asList(
            new Student("Rahul", "Sharma", "Hyderabad", 8.38, 19, "Civil"),
            new Student("Amit", "Verma", "Delhi", 8.4, 21, "IT"),
            new Student("Suresh", "Reddy", "Hyderabad", 7.5, 20, "Civil"),
            new Student("Kiran", "Patel", "Mumbai", 9.1, 20, "IT"),
            new Student("Arjun", "Naidu", "Bengaluru", 7.83, 20, "Civil")
        );
        
        // 1. Find students from Hyderabad with a grade greater than 8.0
        List<Student> HyderabadHighGrades = student.stream()
        		.filter(s-> s.city.equals("Hyderabad") && s.age > 8.0)
        		.toList();
        	System.out.println("1. Find students from Hyderabad with a grade greater than 8.0 \n"+HyderabadHighGrades);	
        
            // 2. Find the student with the highest grade
        Optional<Student> higherGrade = student.stream()
        		.max(Comparator.comparingDouble(s -> s.grade));
        System.out.println("2. Find the student with the highest grade \ni"
        		+ higherGrade.orElse(null));
        
        	//3. Count the number of students in each department 
        Map<String, Long> count = student.stream()
        		.collect(Collectors.groupingBy(s -> s.department, Collectors.counting()));
        System.out.println("3. Count the number of students in each department "+ count);
        
        	// 4. Find the average grade per department
        Map<String, Double> averageGradePerDepartment= student.stream()
        		.collect(Collectors.groupingBy(s -> s.department,Collectors.averagingDouble(i -> i.grade)));
        System.out.println("4. Find the average grade per department "+averageGradePerDepartment);
        
        // 5. List students sorted by age and then by grade
        List<Student> sortByAgeGrade = student.stream()
        		.sorted(Comparator.comparingInt((Student i) -> i.age).thenComparingDouble( (Student i)->i.grade))
        		.collect(Collectors.toList());
        System.out.println("5. List students sorted by age and then by grade \n"+sortByAgeGrade);
        
        //6. Create a comma-separated list of student names 
        String names = student.stream()
        		.map(s -> s.firstName + " " + s.lastName)
        		.collect(Collectors.joining(","));
        System.out.println("6. Create a comma-separated list of student names \n"+names);
        
        // 7. Check if all students are above 18
        Boolean allAbove18= student.stream()
        		.allMatch(s -> s.age > 18);
        System.out.println("7. Check if all students are above 18 : "+allAbove18);
        
        // 8. Find the department with the most students
        String maxStudent = student.stream()
        		.collect(Collectors.groupingBy(s -> s.department , Collectors.counting())).entrySet().stream()
        		.max(Map.Entry.comparingByValue())
        		.map(Map.Entry :: getKey)
        		.orElse("None");
        System.out.println("8. Find the department with the most students : "+maxStudent);
        
        // 9. Divide students into those who have grades above 8.0 and below
        Map<Boolean, List<Student>> gradePartition = student.stream()
                .collect(Collectors.partitioningBy(s -> s.grade > 8.0));
        System.out.println("9. Students partitioned by grade: " + gradePartition);
        
        // 10. Find the student with the longest full name
        Optional<Student> longestFullName = student.stream()
        		.max(Comparator.comparingInt(s -> (s.firstName + s.lastName).length()));
        System.out.println("10. Find the student with the longest full name : "+longestFullName.orElse(null));
       

    }
    
    
    
    
}
 
 class just
 {
	public static void main(String[] args) {
		String sentence = "hello world hello java";
		Map<String, Long> res = Arrays.stream(sentence.split(" "))
				.collect(Collectors.groupingBy(Function.identity() , Collectors.counting()));
		
		System.out.println(res);
		
		
		List<String> list = Arrays.asList("java", "spring", "microservices", "api");
		String res1=list.stream()
				.max(Comparator.comparingInt(i -> i.length()))
				.orElse(null);
	
		System.out.println(res1);
		

		List<Integer> a = Arrays.asList(1,2,3,4);
		List<Integer> b = Arrays.asList(3,4,5,6);
		List<Integer> res2 = Stream.concat(a.stream(), b.stream())
				.distinct()
				.collect(Collectors.toList());
		System.out.println(res2);

				
	}
 }