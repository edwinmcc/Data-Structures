package edu.learn.java.ds.sort;

import edu.learn.java.ds.common.Node;
import edu.learn.java.ds.list.DoublyLinkedList;

import java.util.Arrays;

/*
public class MergeSort {
	/*
	 * Incomplete
	 * /
	
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
} */

public class MergeSort {

    int[] array = { 9,8,7,6,5,4,3,2,1, 0};

    public void merge(int low, int mid, int high) {
		//System.out.printf("merge(%d, %d, %d) \n",low,mid,high);

        // Compute the size of array to split the main array.
        int leftArraySize = mid - low + 1;  // Compute the left part.
        int rightArraySize = high - mid;    // Compute the right part.

		//System.out.printf("Left Half Size : %d Right Half size : %d ",leftArraySize,rightArraySize);

        int[] leftArray = new int[leftArraySize + 1];
        int[] rightArray = new int[rightArraySize +1];

        // Fill the array by copying elements from original array.
        // Copy the left array part.
        for(int i=0;i<leftArraySize;i++) {
            leftArray[i] = array[low + i];
        }

        // Copy the right array part.
        for(int i=0;i<rightArraySize;i++) {
            rightArray[i] = array[mid+i+1];
        }

        // Fill the last element with Max Element.
        leftArray[leftArraySize]=Integer.MAX_VALUE;
        rightArray[rightArraySize] = Integer.MAX_VALUE;

        int i=0;
        int j=0;

        // Iterate through the array low to high and compare elements.
        for(int k = low;k<=high;k++) {
        	//System.out.printf("Comparing leftArray[%d](%d)<=rightArray[%d](%d) \n",i,leftArray[i],j,rightArray[j]);
            if(leftArray[i] <= rightArray[j]) {
				//System.out.printf("array[%d](%d) = leftArray[%d](%d) \n",k,array[k],i,leftArray[i]);
                array[k] = leftArray[i];
                i++;
            }
            else {
				//System.out.printf("array[%d](%d) = rightArray[%d](%d) \n",k,array[k],j,rightArray[j]);
                array[k] = rightArray[j];
                j++;
            }
        }
    }

    public void mergeSort(int low, int high) {
    	//System.out.printf("mergeSort(%d,%d) \n",low,high);
        if(low<high) {
            int mid = (low + high) / 2;
            mergeSort(low, mid);
            mergeSort(mid + 1, high);
            merge(low, mid, high);
        }
    }

    public void printArray() {
        System.out.println("Array : "+ Arrays.toString(array));
    }

    public static void main(String ...args) {
        MergeSort ms=new MergeSort();
        ms.printArray();
        ms.mergeSort(0,ms.array.length-1);
        ms.printArray();
    }
}