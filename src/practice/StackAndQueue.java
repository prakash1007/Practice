package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class StackAndQueue {
	// Array to hold elements
	private int[] stackArray;
	// Maximum capacity
	private int capacity;
	// Index of top element
	private int topIndex;

	// Constructor
	public StackAndQueue(int size) {
		capacity = size;
		stackArray = new int[capacity];
		// Initialize stack as empty
		topIndex = -1;
	}

	public StackAndQueue() {
		this(1000);
	}

	// Pushes element x
	public void push(int x) {
		if(topIndex >= capacity-1)
		{
			System.out.println("Stack Overflow");
			return;
		}
		stackArray[++topIndex]=x;
	}

	// Removes and returns top element
	public int pop() {
		if (isEmpty()) {
            System.out.println("Stack is empty");
            // Return invalid value
            return -1;
        }
		return stackArray[topIndex--];
	}

	// Returns top element
	public int top() {
		if(isEmpty())
		{
			System.out.println("Stack is empty");
			return -1; 
		}
		return stackArray[topIndex];
	}

	/*
	 * Returns true if the stack is empty, false otherwise
	 */
	public boolean isEmpty() {
		return topIndex==-1;
	}

	public static void main(String[] args) {
		StackAndQueue stack = new StackAndQueue();
		List<String> commands = Arrays.asList("ArrayStack", "push", "push", "top", "pop", "isEmpty");
		List<List<Integer>> inputs = Arrays.asList(Arrays.asList(), Arrays.asList(5), Arrays.asList(10),
				Arrays.asList(), Arrays.asList(), Arrays.asList());

		for (int i = 0; i < commands.size(); ++i) {
			switch (commands.get(i)) {
			case "push":
				stack.push(inputs.get(i).get(0));
				System.out.print("null ");
				break;
			case "pop":
				System.out.print(stack.pop() + " ");
				break;
			case "top":
				System.out.print(stack.top() + " ");
				break;
			case "isEmpty":
				System.out.print((stack.isEmpty() ? "true" : "false") + " ");
				break;
			case "ArrayStack":
				System.out.print("null ");
				break;
			}
		}
	}
}



class Paranthesis
{
	public static void main(String[] args) {
        String s = "()[{}()]";
        Stack<Character> st = new Stack<>();  // Stack to store opening brackets
        for (char c : s.toCharArray())
        {
			if(c == '(' || c == '{' || c == '[')
			{
				st.push(c);
			}
			else
			{
				if(st.isEmpty())
				{
					System.out.println("False");
				return;
				}
				else
				{
					char top = st.pop();
					
					if(!((top == '(' && c == ')' ) ||
						(top == '{' && c == '}' ) ||
						(top == '[' && c == ']' )))
					{
						System.out.println("False");
						return;
					}
				}
			}
		}
        if(st.isEmpty())
		{
			System.out.println("True");
		}
        else {
        	System.out.println("False");
        }
	}
}


class NextSmaller
{
	public static void main(String[] args) {
		int[] arr = {4, 8, 5, 2, 25};
		// [2, 5, 2, -1, -1]
		int n =arr.length;
		int[] res = new int[n];
		Arrays.fill(res, -1);
				
		
		for(int i=0;i<n;i++)
		{
			int curr = arr[i];
			for(int j=i+1;j<n;j++)
			{
				if(arr[j]<curr)
				{
					res[i]=arr[j];
					break;
				}
			}
			
		}
		
		
		for (int i : res) {
			System.out.print(i+" ");
		}
	}
}



class Solutions {

    // Function to find next smaller element using stack
    public int[] nextSmallerElement(int[] arr) {
        int n = arr.length;

        // Stack to keep potential next smaller elements
        Stack<Integer> st = new Stack<>();

        // Initialize result array with -1
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {

            // Pop elements from stack that are not smaller
            while (!st.isEmpty() && st.peek() >= arr[i]) {
                st.pop();
            }

            // If stack not empty, top is the next smaller element
            if (!st.isEmpty()) {
                ans[i] = st.peek();
            }

            // Push current element to stack
            st.push(arr[i]);
        }

        // Return result
        return ans;
    }
}

 class Main2 {
    public static void main(String[] args) {
        int[] arr = {4, 8, 5, 2, 25};
        Solutions sol = new Solutions();

        // Get next smaller elements
        int[] ans = sol.nextSmallerElement(arr);

        // Print result
        System.out.print("The next smaller elements are: ");
        for (int val : ans) {
            System.out.print(val + " ");
        }
    }
}
 
 class LRUCache
 {
	 
	    // Doubly linked list node class
	    class Node {
	        int key;
	        int val;
	        Node next;
	        Node prev;
	        // Constructor to initialize node
	        Node(int _key, int _val) {
	            key = _key;
	            val = _val;
	        }
	    }
	 
	 
	    Node head = new Node(-1,-1);
	    Node tail = new Node(-1,-1);
	    
	    int cap;
	    HashMap<Integer,Node> map = new HashMap<>();
	    
	    public LRUCache(int capacity)
	    {
	    	this.cap = capacity;
	    	head.next = tail;
	    	tail.prev = head;
	    }
	    
	    public int get(int key_)
	    {
	    	if(map.containsKey(key_))
	    	{
	    		Node resNode = map.get(key_);
	    		int res = resNode.val;
	    		//remove old mapping
	    		map.remove(key_);
	    		//delete and move accessed to front
	    		deleteNode(resNode);
	    		addNode(resNode);
	    		map.put(key_, resNode);
	    		return res;
	    	}
	    	return -1;
	    }
	    
	    public void deleteNode(Node node)
	    {
	    	Node delPrev = node.prev;
	    	Node delNext = node.next;
	    	delPrev.next = delNext;
	    	delNext.prev = delPrev;
	    }
	    
	    public void addNode(Node newNode)
	    {
	    	Node temp = head.next;
	    	newNode.next = temp;
	    	newNode.prev = head;
	    	head.next = newNode;
	    	temp.prev = newNode;
	    }
	 
	    
	    public void put(int key_,int val_)
	    {
	    	if(map.containsKey(key_))
	    	{
	    		Node existNode = map.get(key_);
	    		map.remove(key_);
	    		deleteNode(existNode);
	    	}
	    	
	    	if(map.size() == cap)
	    	{
	    		map.remove(tail.prev.key);
	    		deleteNode(tail.prev);
	    	}
	    	
	    	addNode(new Node(key_,val_));
	    	map.put(key_, head.next);
	    	
	    }
 }
	 

 class Test {
     public static void main(String[] args) {

         LRUCache cache = new LRUCache(2);

         List<String> output = new ArrayList<>();

         output.add("null");                 // LRUCache(2)
         cache.put(1, 1); output.add("null");	
         cache.put(2, 2); output.add("null");
         output.add(String.valueOf(cache.get(1)));
         cache.put(3, 3); output.add("null");
         output.add(String.valueOf(cache.get(2)));
         cache.put(4, 4); output.add("null");
         output.add(String.valueOf(cache.get(1)));
         output.add(String.valueOf(cache.get(3)));
         output.add(String.valueOf(cache.get(4)));

         System.out.println(output);
     }
 }
 
 class Node {
	    int key, value, cnt;
	    Node next;
	    Node prev;
	    
	    Node(int _key, int _value) {
	        key = _key;
	        value = _value;
	        cnt = 1;
	    }
	}

 
 
 
  class Test2 {
	    public static void main(String[] args) {
	        // LFU Cache
	       // LFUCache cache = new LFUCache(2);
	        
	        // Queries
//	        cache.put(1, 1);
//	        cache.put(2, 2);
//	        System.out.print(cache.get(1) + " ");
//	        cache.put(3, 3);
//	        System.out.print(cache.get(2) + " ");
//	        System.out.print(cache.get(3) + " ");
//	        cache.put(4, 4);
//	        System.out.print(cache.get(1) + " ");
//	        System.out.print(cache.get(3) + " ");
//	        System.out.print(cache.get(4) + " ");
	    }
	}
 
 
 