package edu.learn.java.ds.concurrent;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Created by egnanasigamony on 20/09/2016.
 */

class FindMaxInSubset extends RecursiveTask<Integer> {

    private int[] array=null;
    private int low;
    private int high;

    private RecursiveTask<Integer> lowRangeTask=null;
    private RecursiveTask<Integer> highRangeTask=null;

    public FindMaxInSubset(int[] array, int low, int high) {
        this.array=array;
        this.low=low;
        this.high=high;
    }

    @Override
    protected Integer compute() {
        int maxValue=Integer.MIN_VALUE;
        System.out.println("Range : low : "+low+" High : "+high);
        if((high-low)>10) {
            int mid=(high+low)/2;
            lowRangeTask = new FindMaxInSubset(array,low,mid);
            highRangeTask = new FindMaxInSubset(array,mid+1,high);
            invokeAll(lowRangeTask,highRangeTask);
            maxValue=Math.max(lowRangeTask.join(),highRangeTask.join());
        }
        else {
            int max=Integer.MIN_VALUE;
            for(int i=low;i<high;i++) {
                if(max<array[i]) {
                    max=array[i];
                }
            }
            maxValue=max;
        }
        return maxValue;
    }
}

public class ForkJoinPoolDemo {
    public static void main(String ...args) {
        int[] array=new int[100];
        Random random=new Random(10);
        for(int i=0;i<100;i++) {
            array[i]=random.nextInt(10000);
            System.out.println(array[i]);
        }
        ForkJoinPool forkJoinPool=new ForkJoinPool();
        FindMaxInSubset findMaxInSubset=new FindMaxInSubset(array,0,array.length-1);
        Integer result=forkJoinPool.invoke(findMaxInSubset);
        System.out.println("The max number in array is : "+result);
    }
}



