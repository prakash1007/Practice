package practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class String_Medium {
	public static void main(String[] args) {
		System.out.println("Hello");
	}
}

class RomanToInt {
	public static void main(String[] args) {
		String s = "XLM";
		Map<Character, Integer> mp = new HashMap<>();
		mp.put('I', 1);
		mp.put('V', 5);
		mp.put('X', 10);
		mp.put('L', 50);
		mp.put('C', 100);
		mp.put('D', 500);
		mp.put('M', 1000);

		int result = mp.get(s.charAt(s.length() - 1));
		for (int i = s.length() - 2; i >= 0; i--) {
			if (mp.get(s.charAt(i)) < mp.get(s.charAt(i + 1))) {
				result -= mp.get(s.charAt(i));
			} else {
				result += mp.get(s.charAt(i));
			}
		}
		System.out.println(result);
	}
}

class RemoveUnwanted {
	public static void main(String[] args) {
		String s = "-91283472332";
		System.out.println(myAtoi(s)); // expected: -12345
	}

	static int myAtoi(String s) {
		int num = 0;
		int i=0;
		int sign=1;
		//removed whitespace
		s=s.trim();
		
		int n=s.length();
		
		if(n==0)
		{
			return 0;
		}
		
		//sign 
		if(i<n && (s.charAt(i)=='+' || s.charAt(i)=='-'))
		{
			sign*=s.charAt(i)=='-'?-1:1;
			i++;
		}
		
		while(i<n && Character.isDigit(s.charAt(i)))
		{
			num=num*10+(s.charAt(i)-'0');
			
			long signed=num*sign;	
			if(signed > Integer.MAX_VALUE)
			{
				return Integer.MAX_VALUE;
			}
			if(signed < Integer.MIN_VALUE)
			{
				return Integer.MIN_VALUE;
			}
			i++; 
		}
			
			return (int)sign*num;
	}
}

class Reverse_Word
{
	public static void main(String[] args) {
		String s = " hello world ";
		StringBuilder result = new StringBuilder();
		int i = s.length()-1;
		
		while(i>=0)
		{
			if(i>=0 && s.charAt(i)==' ')
			{
				 i--;
			}
			int end=i;
			
			if(i<0)break;
			
			while(i>=0 && s.charAt(i)!=' ')
			{
				i--;
			}
			
			String word = s.substring(i+1, end+1);
			
			if(result.length() > 0)
			{
				result.append(" ");
			}
			
			result.append(word);
		}
		System.out.println(result.toString());
	}
}

class rev
{
	public static void main(String[] args) {
		String s = " hello world ";
		String[] res= s.split(" ");
		Collections.reverse(Arrays.asList(res));
		System.out.println(res.toString());
		
	}
}
