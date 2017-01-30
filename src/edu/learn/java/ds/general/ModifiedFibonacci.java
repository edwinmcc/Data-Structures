package edu.learn.java.ds.general;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by edwin on 29/01/17.
 */
public class ModifiedFibonacci  {

    /*
     Tn+2 = Tn + (Tn+1)^2


     T1 = 0
     T2 = 1
     T3 = 0 + (1)^2 = 1
     T4 = 1 + (1)^2 = 2
     T5 = 1 + (2)^2 = 5

     */


    private static BigInteger  fibonacci(long t0, long t1, BigInteger n) {
        if(n.longValue()<=0) {
            return BigInteger.valueOf(t0);
        }
        if(n.longValue()==1) {
            return BigInteger.valueOf(t1);
        }
        return fibonacci(t0,t1,n.subtract(BigInteger.valueOf(2))).add((fibonacci(t0,t1,n.subtract(BigInteger.ONE)).multiply(fibonacci(t0,t1,n.subtract(BigInteger.ONE)))));
    }
    public static void main(String ...args) {
        Scanner scanner = new Scanner(System.in);
        long  t0=scanner.nextLong();
        long  t1=scanner.nextLong();
        long   n = scanner.nextLong();
        for(long i=0;i<n;i++) {
            System.out.println(fibonacci(t0,t1,BigInteger.valueOf(i)));
        }
    }

}
