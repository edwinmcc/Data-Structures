package edu.learn.java.ds.general;

import java.util.Scanner;

/**
 * Created by edwin on 28/11/16.
 */
public class MinMaxSum {



    public static long getMax(long a, long b) {
        if(a>b) { return a; }
        return b;
    }

    public static long getMin(long a, long b) {
        if(a<b) { return a; }
        return b;
    }


    public static void main(String ...args) {
        Scanner in = new Scanner(System.in);
        long min=Long.MAX_VALUE;
        long max=Long.MIN_VALUE;

        long a = in.nextLong();
        min=a;
        max=a;

        long b = in.nextLong();
        min=getMin(min,b);
        max=getMax(max,b);

        long c = in.nextLong();
        min=getMin(min,c);
        max=getMax(max,c);

        long d = in.nextLong();
        min=getMin(min,d);
        max=getMax(max,d);

        long e = in.nextLong();
        min=getMin(min,e);
        max=getMax(max,e);

        long sum=a+b+c+d+e;

        System.out.print((sum-max)+" "+(sum-min));

    }

}
