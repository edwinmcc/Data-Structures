package edu.learn.java.ds.concurrent;

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
        this.low=low;
        this.high=high;
    }

    @Override
    protected Integer compute() {
        int maxValue=Integer.MIN_VALUE;
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

}



