package edu.learn.java.ds.tree;
import edu.learn.java.ds.common.Node;

public class BinaryTree {
	
	Node head=null;
	public void addNode(int value)
	{
		Node newNode=new Node(value);
		if(head==null)
		{
			head=new Node(value);
			return;
		}
		Node n=head;
		System.out.println("Inserting Node : "+newNode.value);
		while(n!=null)
		{
			System.out.println("Processing Node : "+n.value);
			if(value<n.value)
			{
				if(n.left==null)
				{
					System.out.println("Inserting to the node left : "+n.value);
					n.left=newNode;
					break;
				}
				else {
					System.out.println("Moving left "+n.value+" value : "+value);
					n=n.left;
				}
			}
			else if(value>n.value)
			{
				if(n.right==null)
				{
					System.out.println("Inserting to the node right : "+n.value);
					n.right=newNode;
					break;
				}
				else {
					System.out.println("Moving right"+n.value+" value : "+value);
					n=n.right;
				}
			} 
			else if(value==n.value)
			{
				System.out.println("Value is already found "+n.value);
				break;
			}
		}
	}
	
	public void inOrderTraversal(Node n)
	{
		if(n==null)
		{
			return;
		}
		System.out.println("Node : "+n.value);
		inOrderTraversal(n.left);
		inOrderTraversal(n.right);
	}
	
	public void preOrderTraversal(Node n)
	{
		if(n==null)
		{
			return;
		}
		preOrderTraversal(n.left);
		System.out.println("Node : "+n.value);
		preOrderTraversal(n.right);
	}
	
	public void postOrderTraversal(Node n)
	{
		if(n==null)
		{
			return;
		}
		postOrderTraversal(n.right);
		System.out.println("Node : "+n.value);
		postOrderTraversal(n.left);
		
		
	}
	
	public void search(int value)
	{
		Node node=head;
		while(node!=null)
		{
			if(value>node.value)
			{
				node=node.right;
			}
			else if(value<node.value)
			{
				node=node.left;
			}
			System.out.println("Found Node : "+node.value);
			break;
		}
		if(node==null)
		{
			System.out.println("Could not find node ");
		}
	}
	
	public void deleteNode(int value)
	{
		
	}
	
	public void modify(int o,int n)
	{
		
	}
	
	public static void main(String ...args)
	{
		BinaryTree bt=new BinaryTree();
		bt.addNode(40);
		bt.addNode(20);
		bt.addNode(30);
		bt.addNode(50);
		bt.addNode(25);
		bt.addNode(35);
		bt.addNode(45);
		bt.addNode(60); 
		//bt.inOrderTraversal(bt.head);
		System.out.println("In order *****************************");
		bt.inOrderTraversal(bt.head);
		System.out.println("Pre order *****************************");
		bt.preOrderTraversal(bt.head);
		System.out.println("Post order *****************************");
		bt.postOrderTraversal(bt.head);
		
	}
}
