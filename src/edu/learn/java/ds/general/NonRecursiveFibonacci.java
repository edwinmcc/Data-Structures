package edu.learn.java.ds.general;

/**
 * Created by edwin on 9/09/16.
 */
public class NonRecursiveFibonacci {

    public long fibonacci(int n) {
        if(n==0) {
            return 0;
        }
        if(n<=2) {
            return 1;
        }
        int a=1,b=1,c=0;
        for(int i=3;i<=n;i++) {
            c=a+b;
            b=a;
            a=c;
        }
        return c;
    }

    public static void main(String ...args){
        NonRecursiveFibonacci nrf=new NonRecursiveFibonacci();
        System.out.println("Value of Fib 7: "+nrf.fibonacci(20));
    }

}
