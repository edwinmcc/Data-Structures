package edu.learn.java.ds.sort;

import java.util.ArrayList;
import java.util.Collections;

public class BubbleSort {
	
	ArrayList<Integer> intList=new ArrayList<Integer>();
	
	public BubbleSort()
	{
		
	}
	
	public void addToList(Integer i)
	{
		intList.add(i);
	}
	
	
	
	public void sort(boolean ascendingOrder)
	{
		for(int i=0;i<intList.size();i++)
		{
			for(int j=i+1;j<intList.size();j++)
			{
				if((ascendingOrder && intList.get(i).intValue()>intList.get(j).intValue()) || (!ascendingOrder && intList.get(i).intValue()<intList.get(j).intValue()))
				{
					Collections.swap(intList, i, j);
				}
			}
		}
	}
	public void sortInDescendingOrder()
	{
		sort(false);
	}
	
	public void sortInAscendingOrder()
	{
		sort(true);
	}
	
	public void printList()
	{
		for(int i=0;i<intList.size();i++)
		{
			System.out.println("intList["+i+"]="+intList.get(i));
		}
	}
	
	public static void main(String ...args)
	{
		BubbleSort bs=new BubbleSort();
		
		int i=0;
		while(i<100)
		{
			bs.addToList(i);
			i+=2;
		}
		bs.sortInDescendingOrder();
		bs.printList();
		bs.sortInAscendingOrder();
		bs.printList();
	}
	
}
