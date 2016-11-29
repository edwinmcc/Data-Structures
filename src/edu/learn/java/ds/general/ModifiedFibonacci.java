package edu.learn.java.ds.general;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created by egnanasigamony on 29/11/2016.
 */
public class ModifiedFibonacci {

    private static BigDecimal mFib(BigDecimal a, BigDecimal b,int n) {
        BigDecimal sum=new BigDecimal(0);
        sum=sum.add(a);
        sum=sum.add(b);
        for(int i=2;i<n;i++) {
            sum=sum.multiply(sum);
            sum = sum.add(a);
            a=b;
            b=sum;
        }
        return sum;
    }


    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner=new Scanner(System.in);
        BigDecimal a=new BigDecimal(scanner.nextInt());
        BigDecimal b=new BigDecimal(scanner.nextInt());
        int n=scanner.nextInt();
        System.out.println((mFib(a,b,n)));
    }
}
