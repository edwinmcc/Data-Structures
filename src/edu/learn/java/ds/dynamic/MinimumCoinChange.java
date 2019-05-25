package edu.learn.java.ds.dynamic;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class AscendingOrder implements Comparator<Integer>
{

    @Override
    public int compare(Integer o1, Integer o2)
    {
        if(o1.intValue()<o2.intValue())
        {
            return -1;
        }
        else if(o1.intValue()>o2.intValue())
        {
            return 1;
        }
        return 0;
    }
}

class DescendingOrder implements Comparator<Integer>
{

    @Override
    public int compare(Integer o1, Integer o2)
    {
        if(o1.intValue()>o2.intValue())
        {
            return -1;
        }
        else if(o1.intValue()<o2.intValue())
        {
            return 1;
        }
        return 0;
    }
}



public class MinimumCoinChange
{
    public void calculateChange(long number, List<Integer> coins)
    {
        long maximumCoin = getMaximumCoin(number,coins);
        if(maximumCoin==-1)
        {
            return;
        }
        System.out.println("Maximum Coin : "+maximumCoin);
        calculateChange(number-maximumCoin,coins);
    }

    private int getMaximumCoin(long number, List<Integer> coins)
    {
        for(int i=0;i<coins.size();i++)
        {
            if(number>=coins.get(i))
            {
                return coins.get(i);
            }
        }
        return -1;
    }

    public static void main(String ...args)
    {
        List<Integer> coins = Arrays.asList(1,5,2,10);
        Collections.sort(coins, new DescendingOrder());
        MinimumCoinChange cc = new MinimumCoinChange();
        cc.calculateChange(21,coins);
    }
}
