package edu.learn.java.ds.sort;

import edu.learn.java.ds.common.Node;
import edu.learn.java.ds.list.DoublyLinkedList;

public class MergeSort {
	/*
	 * Incomplete
	 */
	
	public void splitList(Node head, Node tail)
	{
		System.out.println("\nHead : "+head.value+" Tail : "+tail.value);
		Node headptr=head;
		Node tailptr=tail;
		while(headptr!=tailptr && headptr.right!=tailptr)
		{
			System.out.println("headptr : "+headptr.value);
			System.out.println("tailptr : "+tailptr.value);
			headptr=headptr.right;
			tailptr=tailptr.left;
		}
		if((head==headptr && tail==tailptr))
		{
			if(headptr.right==tailptr)
			{
				swapValues(headptr,headptr.right);
			}
			return;
		}
		if(headptr==tailptr)
		{
			//System.out.println("Middle Node : "+headptr.value);
			splitList(head,headptr.left);
			splitList(tailptr,tail);
		}
		else if(headptr.right==tailptr)
		{
			//System.out.println("Left Middle Node : "+headptr.value);
			//System.out.println("Right Middle Node : "+tailptr.value);
			splitList(head,headptr);
			splitList(tailptr,tail);
		}
		headptr=head;
		tailptr=tail;
		while(headptr!=tailptr)
		{
			System.out.println("\nComparing : ("+headptr.value+","+tailptr.value+")");
			if(headptr.value>headptr.right.value)
			{
				swapValues(headptr,headptr.right);
			}
			headptr=headptr.right;
		}
		headptr=head;
		tailptr=tail;
		System.out.println("Sorted sublist ");
		while(headptr!=tailptr)
		{
			System.out.print("-->"+headptr.value);
			headptr=headptr.right;
		}
	}
	
	public void swapValues(Node headptr,Node tailptr)
	{
		System.out.println("Swap values("+headptr.value+","+tailptr.value+")");
		int temp=headptr.value;
		headptr.value=tailptr.value;
		tailptr.value=temp;
	}
	
	
	public static void main(String ...args)
	{
		MergeSort ms=new MergeSort();
		DoublyLinkedList dll=new DoublyLinkedList();
		dll.addNode(50);
		dll.addNode(60);
		dll.addNode(40);
		dll.addNode(70);
		dll.addNode(30);
		dll.addNode(80);
		dll.addNode(20);
		dll.addNode(90);
		dll.addNode(100);
		dll.addNode(110);
		
		dll.traverseForward();
		
		ms.splitList(dll.getHead().right, dll.getTail().left);
		//dll.traverseForward();
		
		
	}
	
}
