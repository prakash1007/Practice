package practice;

public class CustomFunctionalInterface {
	public static void main(String[] args) {

	}
}

@FunctionalInterface
interface Pow 
{
	double calculation(double a,double b);
}


class mains
{
	public static void main(String[] args) {
		Pow power = (a,b)-> Math.pow(a, b);
		Pow addition = (a,b) -> a+b;
		Pow multiplication = (a,b) -> a*b;
		int a = 5;
		int b = 2;
		
		System.out.println(power.calculation(a, b));
		System.out.println(addition.calculation(a, b));
		System.out.println(multiplication.calculation(a, b));
	}
}


