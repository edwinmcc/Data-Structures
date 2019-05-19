package edu.learn.java.ds.threads;

public class WaitingReader extends Thread
{
    Calculator calculator;

    public WaitingReader(Calculator calculator)
    {
        this.calculator = calculator;
    }

    public void run()
    {
        synchronized (calculator)
        {
            try
            {
                System.out.println("Waiting for calculation to be completed");
                calculator.wait();
            }
            catch (InterruptedException ie)
            {
                ie.printStackTrace();
            }
            System.out.println("Waking up from sleep");
            System.out.println("The total is "+calculator.total);
        }
    }

    public static void main(String ...args)
    {
        Calculator calculator = new Calculator();

        WaitingReader wr1 = new WaitingReader(calculator);
        WaitingReader wr2 = new WaitingReader(calculator);
        WaitingReader wr3 = new WaitingReader(calculator);
        WaitingReader wr4 = new WaitingReader(calculator);


        wr1.start();
        wr2.start();
        //wr3.start();
        //wr4.start();

        new Thread(calculator).start();
    }

}

class Calculator implements Runnable
{
    int total;

    @Override
    public void run()
    {
        synchronized (this)
        {
            for (int i = 0; i < 100; i++)
            {
                total = total + i;
            }
            notifyAll();
        }
    }
}

