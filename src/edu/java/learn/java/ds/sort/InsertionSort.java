package edu.learn.java.ds.sort;

import edu.learn.java.ds.common.IntegerNode;

public class InsertionSort {
	
	/* Create a doubly linked list.
	 * Insert each node in the appropriate position
	 * Delete node 
	 * For ascending order traverse the list from HEAD
	 * For descending order traverse the list from TAIL
	 * 
	 * Insertion Order : O(n)
	 * Deletion Order  : O(n)
	 * Sort     Order  : O(n)
	 * 
	 * Best case Sort Order : O(n)
	 * Worst case Sort Order : O(n)2
	 * 
	 * 
	 */
	
	private IntegerNode HEAD;
	private IntegerNode TAIL;
	
	public InsertionSort()
	{
		HEAD=new IntegerNode(Integer.MAX_VALUE);
		HEAD.next=null;
		HEAD.prev=null;
		TAIL=new IntegerNode(Integer.MIN_VALUE);
		TAIL.next=null;
		TAIL.prev=null;
	}
	
	private void addNodeAfter(IntegerNode ptrNode, IntegerNode newNode)
	{
		newNode.next=ptrNode.next;
		newNode.prev=ptrNode;
		ptrNode.next.prev=newNode;
		ptrNode.next=newNode;
	}
	
	private void addNodeBefore(IntegerNode ptrNode, IntegerNode newNode)
	{
		newNode.next=ptrNode;
		newNode.prev=ptrNode.prev;
		ptrNode.prev=newNode;
		newNode.prev.next=newNode;
	}
	
	public void addNode(int value)
	{
		IntegerNode newNode=new IntegerNode(value);
		if(HEAD.next==null)
		{
			newNode.next=TAIL;
			newNode.prev=HEAD;
			HEAD.next=newNode;
			TAIL.prev=newNode;
			return;
		}
		IntegerNode ptrNode=HEAD.next;
		if(ptrNode.next==TAIL)
		{
			// There is only one node in list. So compare and insert.
			if(newNode.getValue()>ptrNode.getValue())
			{
				// Insert newnode after ptr
				addNodeAfter(ptrNode, newNode);
			}
			else {
				// Insert newnode before ptr
				addNodeBefore(ptrNode, newNode);
			}
			return;
		}
		boolean added=false;
		while(ptrNode.next!=TAIL)
		{
			if(ptrNode.getValue()>newNode.getValue())
			{
				addNodeBefore(ptrNode, newNode);
				added=true;
				break;
			}
			ptrNode=ptrNode.next;
		}
		if(!added)
		{
			addNodeAfter(ptrNode, newNode);
		}
	}
	
	public void printList()
	{
		IntegerNode ptrNode=HEAD.next;
		while(ptrNode.next!=null)
		{
			System.out.println("Node : "+ptrNode.getValue());
			ptrNode=ptrNode.next;
		}
	}
	
	public void printReverseList()
	{
		IntegerNode ptrNode=TAIL.prev;
		while(ptrNode.prev!=null)
		{
			System.out.println("Node : "+ptrNode.getValue());
			ptrNode=ptrNode.prev;
		}
	}
	
	public void removeNode(int value)
	{
		
	}
	
	public static void main(String ...args)
	{
		InsertionSort is=new InsertionSort();
		is.addNode(50);
		is.addNode(51);
		is.addNode(40);
		is.addNode(60);
		is.addNode(70);
		is.addNode(35);
		is.addNode(30);
		is.printList();
		is.printReverseList();
	}
	
}
