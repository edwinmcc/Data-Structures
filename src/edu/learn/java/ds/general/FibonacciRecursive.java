package edu.learn.java.ds.general;

import java.util.HashMap;

/**
 * Created by egnanasigamony on 8/09/2016.
 */

public class FibonacciRecursive {

    private HashMap<Integer,Integer> keyValueMap=new HashMap<>();

    public int fibonacci(int n) {
        if (n <= 0)
        {
            System.out.println("0 ;;");
            return 0;
        }
        else if (n == 1)
        {
            System.out.println("1 ,,");
            return 1;
        }
        int n2Value=0;
        int n1Value=0;

        if(keyValueMap.containsKey(n-2)) {
            //System.out.println("Got Value of : "+(n-2));
            n2Value=keyValueMap.get(n-2);
        }
        else {
            //System.out.println("Computing Value of : "+(n-2));
            n2Value=fibonacci(n-2);
            keyValueMap.put((n-2),n2Value);
        }

        if(keyValueMap.containsKey(n-1)) {
            //System.out.println("Got Value of : "+(n-1));
            n1Value=keyValueMap.get(n-1);
        }
        else {
            //System.out.println("Computing Value of : "+(n-1));
            n1Value=fibonacci(n-1);
            keyValueMap.put((n-1),n1Value);
        }


        System.out.println(n2Value+n1Value+":: ");
        return n2Value + n1Value;
    }

    public static void main(String ...args) {
        // 0,1,1,2,3,5,8,13, ...
        FibonacciRecursive fr=new FibonacciRecursive();
        System.out.println("Fibonacci : "+fr.fibonacci(6));
    }
}