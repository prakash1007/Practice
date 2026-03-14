package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Recursion {
	public static void main(String[] args) {
		System.out.println("Recurssion ");
	}
}

class Sub_Sum
{
	 // Helper function to recursively find subset sums
    public void findSums(int index, int currentSum, int[] arr, List<Integer> sums) {
    	if(index==arr.length)
    	{
    		sums.add(currentSum);
    		return;
    	}
    	
    	//if picks
    	findSums(index+1, currentSum + arr[index], arr, sums);
    	
    	findSums(index+1, currentSum, arr, sums);
    	
    }

    public List<Integer> subsetSums(int[] arr) {
        List<Integer> sums = new ArrayList<>();
        findSums(0,0,arr,sums);
        Collections.sort(sums);
        return sums;
    }
}

 class Subset_Sums {
    public static void main(String[] args) {
    	Sub_Sum sol = new Sub_Sum();
        int[] arr = {5, 2, 1};
        List<Integer> result = sol.subsetSums(arr);

        for (int sum : result) {
            System.out.print(sum + " ");
        }
        System.out.println();
    }
}

