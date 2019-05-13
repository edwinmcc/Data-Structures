package edu.learn.java.ds.general;

import java.math.BigInteger;
import java.util.HashMap;

/**
 * Created by egnanasigamony on 8/09/2016.
 */

public class FibonacciRecursive {

    private HashMap<Long,Long> keyValueMap=new HashMap<>();

    private HashMap<BigInteger, BigInteger> bigIntMap = new HashMap<>();

    private BigInteger TWO  = BigInteger.ONE.add(BigInteger.ONE);
    public BigInteger fibonacci(BigInteger n)
    {
        if(n.compareTo(TWO)<0)
        {
            return n;
        }
        BigInteger n2Value=BigInteger.ZERO;
        BigInteger n1Value=BigInteger.ZERO;
        if(bigIntMap.containsKey(n.subtract(BigInteger.ONE)))
        {
            n1Value = bigIntMap.get(n.subtract(BigInteger.ONE));
        }
        else
        {
            n1Value=fibonacci(n.subtract(BigInteger.ONE));
            bigIntMap.put(n.subtract(BigInteger.ONE),n1Value);
        }

        BigInteger subTtwo = n.subtract(BigInteger.ONE).subtract(BigInteger.ONE);
        if(bigIntMap.containsKey(subTtwo))
        {
            n2Value = bigIntMap.get(subTtwo);
        }
        else
        {
            n2Value=fibonacci(subTtwo);
            bigIntMap.put(subTtwo,n2Value);
        }
        return n2Value.add(n1Value);
    }

    public long fibonacci(long n) {
        if (n <= 0)
        {
            //System.out.println(0+" ;");
            return 0;
        }
        if (n == 1)
        {
            //System.out.println(1+" ;");
            return 1;
        }

        long n2Value=0;
        long n1Value=0;

        if(keyValueMap.containsKey(n-1))
        {
            n1Value=keyValueMap.get(n-1);
        }
        else
        {
            n1Value=fibonacci(n-1);
            keyValueMap.put((n-1),n1Value);
        }

        if(keyValueMap.containsKey(n-2))
        {
            n2Value=keyValueMap.get(n-2);
        }
        else
        {
            n2Value=fibonacci(n-2);
            keyValueMap.put((n-2),n2Value);
        }
        return n2Value + n1Value;
    }

    public static void main(String ...args)
    {
        // 0,1,1,2,3,5,8,13, ...
        FibonacciRecursive fr=new FibonacciRecursive();
        /*
        for(int i=0;i<80;i++)
        {
            System.out.println(fr.fibonacci(i) +" ");
        }*/

        for(int i=0;i<1500;i++)
        {
            BigInteger number = BigInteger.valueOf(i);
            System.out.println(fr.fibonacci(number) +" ");
        }
    }
}