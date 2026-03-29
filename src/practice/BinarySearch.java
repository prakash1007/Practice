package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class BinarySearch {

	public static void main(String[] args) {
		System.out.println("");
	}

}

class NthRoot
{
	private int nthRoot(int n, int m) {
		for(int i =1 ;i<=m;i++)
		{
			long max = (long) Math.pow(i,n);
			
			if(max==m)
			{
				return i;
			}
			
			if(max>m)
			{
				break;
			}
		}
		return -1;
	}
	
	//Optimized one
	private int nthRoot1(int n, int m) {
		int low = 0;
		int high = m;
		while(low<=high)
		{
			int mid = (high+low)/2;
			int result=1;
			for(int i=0;i<n;i++)
			{
				result*=mid;
				if(mid>m)
					break;
			}
			
			if(result==m)
			{
				return mid;
			}
			if(result>m)
			{
				high=mid-1;
			}
			else
			{
				low=mid+1;
			}
		}
		return -1;
	}
	
	
	//Brute Force
	public static void main(String[] args) {
		int n=3;
		int m=27;
		NthRoot sol = new NthRoot();
		System.out.println("Nth Root: " + sol.nthRoot(n, m));
		System.out.println("Nth Root: " + sol.nthRoot1(n, m));
	}
}




class Median
{
	
	//Optimized
	int findMedian(int[][] matrix) {
		int rows = matrix.length;
		int  coln = matrix[0].length;
		
		int low=0;
		int high=matrix[0][coln-1];
		
		//To find correct max and min val
		for(int i=0;i<rows;i++)
		{
			low=Math.min(low, matrix[i][0]);
			high=Math.max(high, matrix[i][coln-1]);
		}
		
		//Binary search in values
		while(low<high)
		{
			int mid = (high+low)/2;
			int count = 0;
			
			//count no of elements <= mid
			for(int i=0;i<rows;i++)
			{
				count+=countLessEquals(matrix[i],mid);
			}
			int req = (rows*coln+1)/2;
			if(count<req)
			{
				low=mid+1;
			}
			else
			{
				high=mid;
			}
		}
		
		return low;
	}
	
	
	
	private int countLessEquals(int[] row, int mid) {
		int low=0;
		int high=row.length;
		while(low<high)
		{
			int m=(low+high)/2;
			if(row[m]<=mid)
			{
				low=m+1;
			}
			else
			{
				high=m;
			}
		}
		return low;
	}



	//Brute Force
	public static void main(String[] args) {
		int M=3;
		int N=3;
		Median med = new Median();
        int[][] matrix = {
        		{1, 10, 20},
        		{15, 25, 35},
        		{30, 40, 50}
            };
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<N;i++) 
        {
			for(int j=0;j<M;j++)
			{
				list.add(matrix[i][j]);
			}
		}
        Collections.sort(list);
        int size=list.size();
        System.out.println("Brute Median : "+list.get(size/2));
        System.out.println("Optimized Median : "+med.findMedian(matrix));
	}
	
}


class Search_Sorted
{
	//Brute
	public static void main(String[] args) {
		int[] arr = {1,1,2,2,3,3,4,4,5,5,6,6,7};
//		
//		Map<Integer, Long> res = Arrays.stream(arr).boxed()
//				.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
//		
//		List<Integer> res1 =res.entrySet().stream()
//		.filter(i->i.getValue()==1)
//		.map(Map.Entry::getKey)
//		.collect(Collectors.toList());
		
//		System.out.println(res1);
		
		int n=arr.length;
		if(n==1)
		{
			System.out.println(arr[0]);
			return;
		}
		
		for(int i=0;i<n;i++)
		{
			if(i==0)
			{
				if(arr[i]!=arr[i+1])
				{
					System.out.println(arr[i]);
					return;
				}
			}
			if(i==n-1)
			{
				if(arr[i]!=arr[i-1])
				{
					System.out.println(arr[i]);
					return;
				}
			}
			if(arr[i]!=arr[i+1] && arr[i]!=arr[i-1])
			{
				System.out.println(arr[i]);
				return;
			}
		}
				
	}
}

class SearchSort1
{
	public static void main(String[] args) {
		int[] arr = {1,1,2,2,3,3,4,4,5,5,6,6,7};
		int n=arr.length;
        if (arr.length == 1) 
        {
        	System.out.println(arr[0]);
        	return;
        }

		if(arr[0]!=arr[1])
		{
			System.out.println(arr[0]);
			return;
		}
		if(arr[n-1]!=arr[n-2])
		{
			System.out.println(arr[n-1]);
			return;
		}
		int low = 1;
		int high = n-2;
		while(low<=high)
		{
			int mid = (low+high)/2;
			if(arr[mid]!=arr[mid-1] && arr[mid]!=arr[mid+1])
			{
				System.out.println(arr[mid]);
				return;
			}
			if((mid%2==1 && arr[mid]==arr[mid-1] )
			|| (mid%2==0 && arr[mid]==arr[mid+1]))
			{
				low = mid+1;
			}
			else
			{
				high=mid-1;
			}
		}

        System.out.println("No single element found or invalid input.");

	}
}

class FindKthPosition
{
	public static void main(String[] args) {
		int[] arr= {4, 5, 6, 7, 0, 1, 2};
		int k=6;
		int result=-1;
//		for(int i=0;i<arr.length;i++)
//		{
//			if(arr[i]==k)
//			{
//				result=i;
//				break;
//			}
//		}
//		System.out.println(result);
//		}
		
		int low=0;
		int high=arr.length-1;
		while(low<=high)
		{
			int mid=(high+low)/2;
			if(arr[mid]==k)
			{
				result=mid;
				System.out.println(result);
			}
			if(arr[low]<=arr[mid])
			{
				if(k>=arr[low] && k<=arr[mid])
				{
					high=mid-1;
				}
				else
				{
					low=mid+1;
				}
			}
			else
			{
				if(k>=arr[mid] && k<=arr[high])
				{
					low=mid+1;
				}
				else
				{
					high=mid-1;
				}
			}
		}
		}
	}

class MedianSorteed
{
	public static void main(String[] args) {
		int[] arr1 = {1, 3, 4, 7, 10, 12};
		int[] arr2 = {2, 3, 6, 15};
		
		List<Integer> list = new ArrayList<Integer>();
		for (Integer integer : arr1) {
			list.add(integer);
		}
		for (Integer integer : arr2) {
			list.add(integer);
		}
		
		Collections.sort(list);
		//int left2 = cut2 == 0 ? Integer.MAX_VALUE : nums1[cut2-1];
		int n=list.size();
		double median;
		if(n%2==1)
		{
			median = list.get(n/2);
		}
		else
		{
			int left = list.get(n/2 - 1);
			int right = list.get(n/2);
			median = (left+right)/2.0;
		}
		
		System.out.println(median);
		}
}