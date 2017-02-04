package edu.learn.java.ds.common;

public class Node {
	public int value;
	public Node left=null;
	public Node right=null;
	
	public Node(int value) {
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}


}