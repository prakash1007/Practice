package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import practice.Solution.Item;

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

class rep
{
	public static void main(String[] args) {
		int[] nums= {7,6,3,4,1,7,5};
		List<Integer> result = new ArrayList<Integer>();
		int rep=-1;
		int missing=-1;
		for(int i=1;i<=nums.length;i++)
		{
			int count=0;
			for(int j=0;j<nums.length;j++)
			{
				if(nums[j]==i)
				{
					count++;
				}
			}
			if(count==2)rep=i;
			else if(count==0)missing=i;
			
			// Stop early if both found
            if (rep != -1 && missing != -1)
                break;
		}
		System.out.println(missing+" "+rep);
	}
}



class Solution {
    // Comparator function to sort items by value/weight ratio
    static class ItemComparator implements Comparator<Item> {
    		public int compare(Item a, Item b) {
    			double r1 = (double)a.value/(double)a.weight;
    			double r2 = (double)b.value/(double)b.weight;
    			return Double.compare(r2, r1);
    		}
    }

    // Method to calculate the maximum value we can get with fractional knapsack
    public double fractionalKnapsack(int W, Item[] arr, int n) {
    		int curr_wt=0;
    		double final_Val=0.0;
    		
    		Arrays.sort(arr,new ItemComparator());
    		for(int i=0;i<n;i++)
    		{
    			if(curr_wt + arr[i].weight<=W)
    			{
    				curr_wt=curr_wt+arr[i].weight;
    				final_Val=final_Val+arr[i].value;
    			}
    			else
    			{
    				int remain = W - curr_wt;
    				final_Val+=(arr[i].value/(double)arr[i].weight)*(double)curr_wt;
    				break;
    			}
    		}
    		return final_Val;
    }

    // Class to represent an item with value and weight
  static  class Item {
        int value;
        int weight;

        Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
    }
}

 class Main {

    public static void main(String[] args) {
        
        // Input data
        int n = 3, weight = 50;  // Number of items and capacity of knapsack
        Item[] arr = { new Item(100, 20), new Item(60, 10), new Item(120, 30) };

        // Create an object of the Solution class
        Solution obj = new Solution();

        // Calculate the maximum value we can get with the fractional knapsack
        double ans = obj.fractionalKnapsack(weight, arr, n);

        // Output the result
        System.out.println("The maximum value is: " + String.format("%.2f", ans));
    }
}