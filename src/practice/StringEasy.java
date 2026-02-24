package practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringEasy {
	public static void main(String[] args) {
		System.out.println("Hello world");
	}
}

class reverseString
{
	public static void main(String[] args) {
		String s="Stay hard my friend";
		String res= Arrays.stream(s.split(" "))
				.collect(Collectors.collectingAndThen(Collectors.toList(),i->{
				Collections.reverse(i);
				return String.join(" ", i);
				}));
		System.out.println(res);
	}
}

class oddOne
{
	public static void main(String[] args) {
		String s = "0045678";
		int ind=-1;
		for(int i=s.length()-1;i>=0;i--)
		{
			if((s.charAt(i) -'0')%2==1)
			{
				ind=i;
				break;
			}
		}
			if(ind==-1)
			{
				System.out.println("");
			}
			else
			{
				System.out.println(s.substring(0, ind+1));
			}
	}
}

class longest_common_prefix
{
	public static void main(String[] args) {
		String[] s = {"accept","acoss","act"};
		Arrays.sort(s);
		String s1 = s[0];
		String s2 = s[s.length-1];
		String s3=null;
		int res=0;
		for(int i=0;i< Math.min(s1.length(), s2.length());i++)
		{
			if(s1.charAt(i) == s2.charAt(i))
			{
				res++;
			}
			else
			{
				break;
			}
		}
		s3=s1.substring(0, res);
		System.out.println(s3);
		
	}
}

class isomorphicString
{
	public static void main(String[] args) {
        String s = "foo";
        String t = "bat";
        boolean result=true;
        if(s.length()!=t.length()) 
        {
        	result=false;
        }

        HashMap<Character, Character> mapST = new HashMap<>();
        HashMap<Character, Character> mapTS = new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
        	char st=s.charAt(i);
        	char ts=t.charAt(i);
        	if(mapST.containsKey(st) && (mapST.get(st)!=(ts)) )
        	{
        			result=false;
        			break;
        	}
        		else if(mapTS.containsKey(ts) && (mapTS.get(ts)!=(st)))
        		{
            			result=false;
            			break; 
        		}
        		else
        		{
        			mapST.put(st, ts);
        			mapTS.put(ts, st);
        		}
        	}
        System.out.println(result);
       
	}
}

class StringRotation
{
	public static void main(String[] args) {
		String s = "fool";
		String goal = "olfo";
		boolean result = false;
		String compare = s + s;
		if(compare.contains(goal))
		{
			result=true;
		}
		System.out.println("rotation "+result);
	}
}

class Anagram
{//BRUTE
	public static void main(String[] args) {
        String Str1 = "ROOM";
        String Str2 = "MORO";
        boolean result = true ;
        char[] arr1 = Str1.toCharArray();
        char[] arr2 = Str2.toCharArray();
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        for(int i=0;i<Str1.length();i++)
        {
        	if(arr1[i]!=arr2[i])
        	{
        		result = false;
        		break;
        	}
        }
        System.out.println(result);
	}
}

class freq
{
	public static void main(String[] args) {
		String s = "tree";
		Map<String, Long> map = Arrays.stream(s.split(""))
				.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		
		String[] result = map.entrySet().stream()
				.sorted((a,b) -> Long.compare(b.getValue(), a.getValue()))
				.map(Map.Entry::getKey)
				.toArray(String[]::new);
		
		System.out.println(Arrays.toString(result));

	}
}


class NestingDepth
{
	public static void main(String[] args) {
		String s = "(1+(2*3)+((8)/4))+1";
		int arr=0;
		int res=0;
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)=='(')
			{
				arr++;
				res=Math.max(arr, res);
			}
			else if(s.charAt(i)==')')
			{
				arr--;
			}
		}
		System.out.println(res);
	}
}

class Roman
{
	public static void main(String[] args) {
		
	}
}