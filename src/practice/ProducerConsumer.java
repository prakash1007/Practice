	package practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProducerConsumer {
		public static void main(String[] args) {
			SharedResourse sharedResourse = new SharedResourse();
			
			Thread t1 = new Thread(() ->
			{
				for(int i=0;i<3;i++) {
					try
					{
						sharedResourse.produce(i);
					}
					catch(InterruptedException e)
					{
						e.printStackTrace();
					}
				}
			}
			);
			
			Thread t2 = new Thread(() ->
			{
				for(int i=0;i<3;i++) {
					try
					{
						sharedResourse.consume(i);
					}
					catch(InterruptedException e)
					{
						e.printStackTrace();
					}
				}
			}
			);
			
			t1.start();
			t2.start();
			
		}
	}
	
	class SharedResourse
	{
		boolean isDataAvailable=false;
		
		
		public synchronized void produce(int i) throws InterruptedException
		{
			if(isDataAvailable)
			{
				wait();
			}
			System.out.println("Produced "+i);
			isDataAvailable=true;
			notify();
		}
		
		public synchronized void consume(int i) throws InterruptedException
		{
			if(!isDataAvailable)
			{
				wait();
			}
			System.out.println("Consumed "+i);
			isDataAvailable=false;
			notify();
		}
	}

class arrange
{
	public static void main(String[] args) {
		String[] s={"Capgemini","Accenture","TCS","EPAM"};
		List<String> s1 = Arrays.stream(s)
				.sorted(Comparator.comparingInt(String::length).reversed()
				.thenComparing(Comparator.naturalOrder()))
				.collect(Collectors.toList());
		System.out.println(s1);
		
	}
}