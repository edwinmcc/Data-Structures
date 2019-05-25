package edu.learn.java.ds.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class NumberCoin
{
    private long number;
    private int  coin;

    public NumberCoin(long number, int coin)
    {
        this.number = number;
        this.coin =coin;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(this==obj)
        {
            return true;
        }
        if(obj==null || obj.getClass()!=this.getClass())
        {
            return false;
        }
        NumberCoin other = (NumberCoin)obj;
        return other.number==number && other.coin==coin;
    }
}

public class CoinChangeCombinations
{
    HashMap<NumberCoin, List<Integer>> numberCoinList =new HashMap<>();
    int totalAmount;
    private int indentation = 0;

    private void printList(List<Integer> path)
    {
        if(path.get(0)==totalAmount)
        {
            for(int entry : path)
            {
                System.out.print(" "+entry);
            }
            System.out.println();
        }
    }

    public void calculateChange(int number, List<Integer> coins,List<Integer> oldPath)
    {
        if(number<0)
        {
            System.out.println("No Solution");
            return;
        }
        if(number==0)
        {
            System.out.println("Possible Solution");
            printList(oldPath);
            return;
        }
        //System.out.println();
        for(int i=0;i<indentation;i++)
        {
            System.out.print(" ");
        }
        System.out.println("number : "+number);
        for(int i=number;i>=0;i--)
        {
            List<Integer> paths = new ArrayList<>();
            paths.add(i);
            System.out.println("Calculate change for i = "+i);
            for (int j = 0; j < coins.size(); j++)
            {
                indentation += 4;
                System.out.println("Using coin "+coins.get(j)+" for number i "+i);
                if(i-coins.get(j)>=0)
                {
                    paths.add(coins.get(j));
                    calculateChange(i - coins.get(j), coins, paths);
                }
                indentation -= 4;
            }
        }
    }

    public static void main(String ...args)
    {
        List<Integer> coins = Arrays.asList(1,2,5);
        //Collections.sort(coins, new DescendingOrder());
        CoinChangeCombinations cc = new CoinChangeCombinations();
        cc.totalAmount = 5;
        cc.calculateChange(cc.totalAmount,coins,new ArrayList<Integer>());
    }

}
