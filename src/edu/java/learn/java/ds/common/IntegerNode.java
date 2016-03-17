package edu.learn.java.ds.common;

public class IntegerNode {
	
	private int value;
	public IntegerNode next;
	public IntegerNode prev;
	
	public IntegerNode(int value)
	{
		this.value=value;
	}
	
	public int getValue()
	{
		return value;
	}
	
	/*
	public void setNext(IntegerNode n)
	{
		// We allow null here;
		next=n;
	}
	
	public IntegerNode getNext()
	{
		return next;
	}
	
	public void setPrev(IntegerNode p)
	{
		prev=p;
	}
	
	public IntegerNode getPrev()
	{
		return prev;
	} */
}