package practice;

public class Array_Hard {
	public static void main(String[] args) {
		System.out.println("Stay hard");
	}
}

class Missing_Repeating
{
	public static void main(String[] args) {
		int[] nums= {3,5,4,1,1};
		int n=nums.length;
		int missing=-1;
		int repeating=-1;
		for(int i=1;i<=n;i++) {
			int count=0;
			for(int j=0;j<n;j++)
			{
				if(nums[j]==i)
				{
					count++;
				}
			}
			
				if(count==2)
					repeating=i;
				else if(count==0)
					missing=i;
				if(missing!=-1 && repeating!=-1)
				{
					break;
				}
		}
		System.out.println(repeating+" "+missing);
	}
}		

class sqrt
{
	public static void main(String[] args) {
		int N=28;
		int res=0;
		for(int i=0;i<=N;i++)
		{
			if((long) i * i <= N)
			{
				res=i;
			}
			else
			{
				break;
			}
		}
		System.out.println(res);
	}
} 
