package edu.learn.java.ds.dynamic;

class Item
{
    private String name;
    private long   weight;
    private long   value;

    public String getName()
    {
        return name;
    }

    public long getWeight()
    {
        return weight;
    }

    public long getValue()
    {
        return value;
    }

    public Item(String name, long weight, long value)
    {
        this.name = name;
        this.weight = weight;
        this.value = value;
    }
}

public class ZeroOneKnapSack
{
    public void compute()
    {
        int maxWeight = 9;
        int numberOfItem = 4;
        Item[] items = new Item[4];

        long[][] matrix = new long[numberOfItem+1][maxWeight+1];

    }
}
