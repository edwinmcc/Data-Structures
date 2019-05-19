package edu.learn.java.ds.general;

import java.util.Comparator;

enum Unit
{
    MILLIMETER (1),
    CENTIMETER (10),
    METER (1000),
    KILOMETER (1000000);

    private final long conversionUnit;

    Unit(final long cUnit)
    {
        conversionUnit = cUnit;
    }

    public long getConversionUnit()
    {
        return conversionUnit;
    }
}

class Distance
{
    private final int distance;
    private final Unit unit;

    public Distance(int distance, Unit unit)
    {
        this.distance = distance;
        this.unit = unit;
    }

    public long getBaseDistance()
    {
        return distance * unit.getConversionUnit();
    }
}

class DistanceComparator implements Comparator<Distance>
{
    @Override
    public int compare(Distance o1, Distance o2)
    {
        int returnVal = ((int)(o1.getBaseDistance()-o2.getBaseDistance()));
        if(returnVal == 0)
        {
            System.out.println("Both these are the same");
        }
        return returnVal;
    }
}

public class SortedList
{
    public static void main(String ...args)
    {

    }
}
