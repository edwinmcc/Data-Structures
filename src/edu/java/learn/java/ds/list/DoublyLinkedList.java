package edu.learn.java.ds.list;

import edu.learn.java.ds.common.Node;

public class DoublyLinkedList {
	
	private Node head;
	private Node tail;
	
	public void addNode(int value)
	{
		Node n=new Node(value);
		if(head==null && tail==null)
		{
			head=new Node(-1);
			head.right=n;
			tail=new Node(-1);
			tail.left=n;
			n.left=head;
			n.right=tail;
			return;
		}
		n.left=tail.left;
		n.right=tail;
		n.left.right=n;
		tail.left=n;
	}
	
	public void traverseForward() 
	{
		if(head==null)
		{
			return;
		}
		Node ptr=head.right;
		while(ptr!=tail)
		{
			System.out.println("Value : "+ptr.value);
			ptr=ptr.right;
		}
	}
	
	public void traverseBackward() 
	{
		if(tail==null)
		{
			return;
		}
		Node ptr=tail.left;
		while(ptr!=head)
		{
			System.out.println("Value : "+ptr.value);
			ptr=ptr.left;
		}
	}
	
	public Node getHead()
	{
		return head;
	}
	
	public Node getTail()
	{
		return tail;
	}
	
	public static void main(String ...args)
	{
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
		
		dll.traverseForward();
		dll.traverseBackward();
		
	}
	
}
