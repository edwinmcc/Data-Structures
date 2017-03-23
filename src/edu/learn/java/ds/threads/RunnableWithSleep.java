package edu.learn.java.ds.threads;

import java.util.concurrent.*;

/**
 * Created by egnanasigamony on 1/03/2017.
 */

public class RunnableWithSleep implements Runnable {

    public void run() {
        try {
            String threadName = Thread.currentThread().getName();
            System.out.println("Foo : " + threadName);
            TimeUnit.SECONDS.sleep(5);
            System.out.println("Bar : " + threadName);
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String ...args) {
        /*
        RunnableWithSleep rws=new RunnableWithSleep();
        Thread t=new Thread(rws);
        t.start();
        rws.run();
        */

        try {

            ExecutorService executorService= Executors.newFixedThreadPool(2);

            RunnableWithSleep rws1=new RunnableWithSleep();
            RunnableWithSleep rws2=new RunnableWithSleep();

            Future result1=executorService.submit(rws1);
            Future result2=executorService.submit(rws2);

            result1.get();
            result2.get();

            executorService.shutdown();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
