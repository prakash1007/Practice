package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearch {

	public static void main(String[] args) {
		System.out.println("fuck off");
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
	//Brute Force
	public static void main(String[] args) {
		int M=3;
		int N=3;
        int[][] matrix = {
                {1, 3, 5},
                {2, 6, 9},
                {3, 6, 9}
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
        System.out.println(list.get(size/2));
	}
}