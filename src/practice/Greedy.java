package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Greedy {
	public static void main(String[] args) {
		System.out.println("Hi from Greedy");
	}
}

class Greedy_Meeting {
	public static void main(String[] args) {
		int[] start = {1, 2, 4, 5, 6};
        int[] end   = {7, 3, 5, 3, 1};
        List<int[]> meeting = new ArrayList<>();
        for(int i=0;i<start.length;i++)
        {
        	meeting.add(new int[] {end[i],start[i],i+1});
        }
        
        meeting.sort(Comparator.comparingInt(a -> a[0]));
        
        List<Integer> result = new ArrayList<Integer>();
        int lastEnd = -1;
        for(int[] m:meeting)
        {
        	if(m[1]>lastEnd)
        	{
        		result.add(m[2]);
        		lastEnd=m[0];
        	}
        }
        for(int s:result)
        {
        	System.out.println(s);
        }
	}
}


class Train
{
	public static void main(String[] args) {
        int[] arr = {900, 945, 955, 1100, 1500, 1800};
        int[] dep = {920, 1200, 1130, 1150, 1900, 2000};
        
       int i=0;
       int j=0;
       int n=arr.length;
       
       Arrays.sort(arr);
       Arrays.sort(dep);
       
       int count=0;
       int maxCount=0;
       
       while(i<n)
       {
    	   if(arr[i]<=dep[j])
    	   {
    		   count++;
    		   i++;
    	   }
    	   else
    	   {
    		   count--;
    		   j++;
    	   }
    	   
    	   maxCount=Math.max(maxCount, count);
       }
       
       System.out.println(maxCount);
       
        
	}
}