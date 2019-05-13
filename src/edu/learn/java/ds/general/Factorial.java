package edu.learn.java.ds.general;

public class Factorial
{
    public long calculateFactorial(long number)
    {
        return factorial(number);
    }

    private long factorial(long number)
    {
        if(number==1)
        {
            return 1;
        }
        return number * factorial(number-1);
    }


    public static void main(String ...args)
    {
        Factorial factorial = new Factorial();
        System.out.println("The factorial of 5 is : "+factorial.calculateFactorial(5));
    }
}
