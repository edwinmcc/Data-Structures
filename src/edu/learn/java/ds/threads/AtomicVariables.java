package edu.learn.java.ds.threads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by egnanasigamony on 1/03/2017.
 */
public class AtomicVariables {

    long normal=0;
    AtomicLong atomicLong=new AtomicLong(0);

    public void incrementNormal() {
        normal++;
    }

    public void incrementAtomic() {
        atomicLong.incrementAndGet();
    }

    Runnable normalRunnable= new Runnable() {
        public void run() {
            for(int i=0;i<1000;i++) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    incrementNormal();
                    System.out.println("Inside Normal Runnable : "+normal);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
    };

    Runnable atomicRunnable = new Runnable() {
        public void run() {
            for (int i=0;i<1000;i++) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    incrementAtomic();
                    System.out.println("Inside Atomic Runnable : "+atomicLong.get());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    };

    public static void main(String ...args) {

        ExecutorService service= Executors.newFixedThreadPool(5);

        AtomicVariables av=new AtomicVariables();
        Future f1=service.submit(av.normalRunnable);
        Future f2=service.submit(av.atomicRunnable);

        HashMap map=null;

        for(int i=0;i<100000;i++) {
            try {
                Thread.currentThread().sleep(100);
                System.out.println("Value of Normal "+av.normal);
                System.out.println("Value of Atomic "+av.atomicLong);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
