package practice;

public class Rev {
	public static void main(String[] args) {
		String str=".Mam.";
		String res="";
		for(int i=str.length()-1;i>=0;i--)
		{
			res+=str.charAt(i);
		}
		System.out.println(res);
	}
}
