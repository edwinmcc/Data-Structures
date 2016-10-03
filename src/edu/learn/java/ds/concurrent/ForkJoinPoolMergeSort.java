package edu.learn.java.ds.concurrent;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

/**
 * Created by egnanasigamony on 21/09/2016.
 */

class MergeSortRecursiveAction extends RecursiveAction {

    private int[] array;
    private int low;
    private int high;
    private int threshold;

    public MergeSortRecursiveAction(int[] array, int low, int high,int threshold) {
        this.array=array;
        this.low=low;
        this.high=high;
        this.threshold=threshold;
        //System.out.println("Low : "+low+" high : "+high);
    }

    private void merge(int low, int mid, int high) {
        int lowArraySize=mid-low+1;
        int highArraySize=high-mid;
        int[] lowArray=new int[lowArraySize+1];
        int[] highArray=new int[highArraySize+1];
        for(int i=0;i<lowArraySize;i++) {
            lowArray[i]=array[low+i];
        }
        for(int i=0;i<highArraySize;i++) {
            highArray[i]=array[mid+i+1];
        }

        lowArray[lowArraySize]=Integer.MAX_VALUE;
        highArray[highArraySize]=Integer.MAX_VALUE;

        int i=0;
        int j=0;
        for(int index=low;index<=high;index++) {
            if(lowArray[i]<=highArray[j]) {
                array[index]=lowArray[i];
                i++;
            }
            else {
                array[index]=highArray[j];
                j++;
            }
        }
    }

    @Override
    protected void compute() {
        if((high-low)<=threshold) {
            Arrays.sort(array,low,high);
            return;
        }
        int mid=(low+high)/2;
        MergeSortRecursiveAction leftAction=new MergeSortRecursiveAction(array,low,mid,threshold);
        MergeSortRecursiveAction rightAction=new MergeSortRecursiveAction(array,mid+1,high,threshold);
        invokeAll(leftAction,rightAction);
        leftAction.join();
        rightAction.join();
        merge(low,mid,high);
    }
}

public class ForkJoinPoolMergeSort {

    private int[] array=null;
    private int   sizeLimit=0;

    /*
    private void merge(int low, int mid, int high) {
        int lowArraySize=mid-low+1;
        int highArraySize=high-mid;
        int[] lowArray=new int[lowArraySize+1];
        int[] highArray=new int[highArraySize+1];
        for(int i=0;i<lowArraySize;i++) {
            lowArray[i]=array[low+i];
        }
        for(int i=0;i<highArraySize;i++) {
            highArray[i]=array[mid+i+1];
        }

        lowArray[lowArraySize]=Integer.MAX_VALUE;
        highArray[highArraySize]=Integer.MAX_VALUE;

        int i=0;
        int j=0;
        for(int index=low;index<=high;index++) {
            if(lowArray[i]<=highArray[j]) {
                array[index]=lowArray[i];
                i++;
            }
            else {
                array[index]=highArray[j];
                j++;
            }
        }

    }

    private void mergeSort(int low, int high) {
        if((high-low)<sizeLimit) {
            Arrays.sort(array,low,high);
            return;
        }
        if(low<high) {
            int mid = (low + high) / 2;
            mergeSort(low, mid);
            mergeSort(mid + 1, high);
            merge(low, mid, high);
        }
    } */

    public void sort(int low,int high,int threshold) {
        MergeSortRecursiveAction msra=new MergeSortRecursiveAction(array,low,high,threshold);
        msra.invoke();
    }

    public static void main(String ...args) {
        ForkJoinPoolMergeSort fjpm=new ForkJoinPoolMergeSort();
        int[] array= { 0,9,8,7,6,5,4,3,2,1,20,19,18,17,16,15,14,13,12,11,30,39,38,37,36,35,34,33,32,31,40,49,48,47,46,45,44,43,42,41 };
        fjpm.array=array;
        fjpm.sizeLimit=10;
        System.out.println(Arrays.toString(array));
        fjpm.sort(0,array.length-1,10);
        System.out.println(Arrays.toString(array));
    }
}
