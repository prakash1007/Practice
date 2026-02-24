package practice;

import java.util.HashMap;
import java.util.Map;

public class Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
	}

}

class ar
{
	public static void main(String[] args) {
		int a[]= {0,3,4,5,-4,-5};
		int n=a.length;
		Map<Integer, Integer> map=new HashMap<>();
		int max=0;
		int sum=0;
		for(int i=0;i<n;i++)
		{
			sum+=a[i];			
			if(sum==0)
			{
				max=i+1;
				
			}
			else if(map.containsKey(sum))
			{
				max=Math.max(max,i-map.get(sum));
			}
			else
			{
				map.put(sum, i);
			}
		}
		System.out.println(max);
	}
}

class sqrt1
{
	public static void main(String[] args) {
		int N=36;
		double r=Math.sqrt(N);
		System.out.println(r);
	}
}

























