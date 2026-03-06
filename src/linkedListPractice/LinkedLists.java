package linkedListPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LinkedLists {
	public static void main(String[] args) {
		System.out.println("All about Linked List");
	}
}

class Node {
	int data;
	Node next;

	Node(int data1, Node next1) {
		this.data = data1;
		this.next = next1;
	}

	Node(int data1) {
		this.data = data1;
		this.next = null;
	}
}

class LinkedList {
	public static Node convertAll2LL(int[] arr) {
		Node head = new Node(arr[0]);
		Node mover = head;
		for (int i = 1; i < arr.length; i++) {
			Node temp = new Node(arr[i]);
			mover.next = temp;
			mover = temp;
		}
		return head;
	}

	public static int lengthOfAll(Node head) {
		int count = 0;
		Node temp = head;
		while (temp != null) {
			temp = temp.next;
			count++;
		}
		return count;
	}

	public static int checkIfPresent(Node head, int val) {
		Node temp = head;
		while (temp != null) {
			if (temp.data == val)
				return 1;
			temp = temp.next;
		}
		return 0;
	}

	public static Node removeHead(Node head) {
		if (head == null)
			return head;
		head = head.next;
		return head;
	}

	public static Node removeTail(Node head) {
		if (head == null || head.next == null)
			return null;
		Node temp = head;
		while (temp.next.next != null) {
			temp = temp.next;
		}
		temp.next = null;
		return head;
	}

	public static void printList(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public static Node removeK(Node head, int k) {
		if (head == null)
			return head;

		if (k == 1) {
			head = head.next;
			return head;
		}
		Node temp = head;
		Node prev = null;
		int count = 0;
		while (temp != null) {
			count++;
			if (k == count) {
				prev.next = prev.next.next;
				break;
			}
			prev = temp;
			temp = temp.next;
		}

		return head;
	}

	public static Node insertHead(Node head, int val) {
		return new Node(val, head);
	}

	public static Node insertTail(Node head, int val) {
		if (head == null) {
			return new Node(val);
		}
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		Node newNode = new Node(val);
		temp.next = newNode;
		return head;
	}

	public static Node insertK(Node head, int val, int k) {
		if (k == 1) {
			return new Node(val, head);
		}
		if (head == null) {
			return head;
		}

		int count = 1;
		Node temp = head;
		while (temp != null) {
			if (count == k - 1) {
				Node x = new Node(val, temp.next);
				temp.next = x;
				break;
			}
			temp = temp.next;
			count++;
		}
		return head;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 4, 6, 8 };
		// Linked List
		// Node y = new Node(arr[0]);
		// System.out.println(y.data);

		// Head of the LL
		Node head = convertAll2LL(arr);
		System.out.println("Current head : " + head.data);

		System.out.print("Traversal of all element : ");

		// Traversal in LL
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();

		// Length in LL
//		int length = lengthOfAll(head);
//		System.out.println("\nLength of the Arrays are : "+length);	

		// Searching an Element
//		int ifPresent = checkIfPresent(head, 2);
//		if(ifPresent==1)
//		{
//		System.out.println("Given number is Present");
//		}
//		else
//		{
//			System.out.println("Given number is Not Present");
//		}
//		

		// delete the head
		// head= removeHead(head);
//		System.out.print("After removed head : ");
//		printList(head);

		// delete the tail
		// head= removeTail(head);
//		System.out.print("After removed tail : ");
//		printList(head);

		// delete k element
//		int k=4;
//		head = removeK(head,k);
//		System.out.print("After removed k : ");
//		printList(head);

		// insert the element
//		head=insertHead(head,0);
//		System.out.print("insert the element : ");
//		printList(head);

//		head=insertTail(head,10);
//		System.out.print("insert the element at tail : ");
//		printList(head);

		head = insertK(head, 100, 5);
		System.out.print("insert the element at K : ");
		printList(head);

	}
}

//Node class represents a node in a linked list
class Node1 {
	// Data stored in the node
	int data;

	// Pointer to the next node
	Node1 next;

	// Constructor with both data and next node
	Node1(int data1, Node1 next1) {
		data = data1;
		next = next1;
	}

	// Constructor with only data
	Node1(int data1) {
		data = data1;
		next = null;
	}
}

//Solution class containing the loop length function
class Solution {
	// Function to return the length of loop using hashing
	public int lengthOfLoop(Node1 head) {
//     HashMap<Node1, Integer> visitedNodes = new HashMap<>();
//     int timer=0;
//     
//     Node1 temp=head;
//     while(temp!=null)
//     {
//    	 if(visitedNodes.containsKey(temp))
//    	 {
//    		 int loopLength=timer-visitedNodes.get(temp);
//    		 return loopLength;
//    	 }
//    	 visitedNodes.put(temp, timer);
//    	 temp=temp.next;
//    	 timer++;
//     }
//     return 0;

		Node1 slow = head;
		Node1 fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				int length = 1;
				Node1 temp = fast.next;
				while (temp != fast) {
					length++;
					temp = temp.next;
				}
				return length;
			}

		}

		return 0;

	}
}

//Main driver class
class Mains {
	public static void main(String[] args) {
		// Creating a sample linked list with a loop
		Node1 head = new Node1(1);
		Node1 second = new Node1(2);
		Node1 third = new Node1(3);
		Node1 fourth = new Node1(4);
		Node1 fifth = new Node1(5);

		// Linking the nodes
		head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;

		// Creating a loop from fifth to second
		fifth.next = second;

		// Creating a Solution object
		Solution obj = new Solution();

		// Getting the loop length
		int loopLength = obj.lengthOfLoop(head);

		// Printing the result
		if (loopLength > 0) {
			System.out.println("Length of the loop: " + loopLength);
		} else {
			System.out.println("No loop found in the linked list.");
		}
	}
}

