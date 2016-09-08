package edu.learn.java.ds.sort;

import java.util.Arrays;

/**
 * Created by edwin on 8/09/16.
 */
public class QuickSort {

    // Full Implementation of Cormen 3rd edition.

    int[] array = { 9,8,7,6,5,4,3,2,1, 100, 74,93,13 };

    private void swap(int i, int j) {
        int temp=array[i];
        array[i]=array[j];
        array[j] = temp;
    }

    private int partition(int low, int high) {
        int pivot=array[high];
        int i    =low-1;
        for(int j=low;j<high;j++) {
            if(array[j]<=pivot) {
                i = i+1;
                swap(i,j);
            }
        }
        swap(i+1,high);
        return i+1;
    }

    public void quicksort(int low, int high) {
        if(low<high) {
            int mid=partition(low,high);
            quicksort(low,mid-1);
            quicksort(mid+1,high);
        }
    }

    public void sort() {
        System.out.println("Before Sorting : "+ Arrays.toString(array));
        quicksort(0,array.length-1);
        System.out.println("Before Sorting : "+ Arrays.toString(array));
    }

    public static void main(String ...args) {
        QuickSort qs=new QuickSort();
        qs.sort();
    }

}
