package edu.learn.java.ds.threads;

/**
 * Created by egnanasigamony on 1/03/2017.
 */

class AddTask implements Runnable  {

    int a=10;
    int b=20;
    int result=0;

    public AddTask(int a, int b) {
        this.a=a;
        this.b=b;
    }

    public void run() {
        System.out.println("Adding in thread : "+Thread.currentThread().getName());
        result=a+b;
    }

    public int getResult() {
        return result;
    }

}

public class RunnableDemo {

    public static void main(String ...args) {
        AddTask addTask=new AddTask(200,300);
        Thread t=new Thread(addTask);
        addTask.run();
        t.start();
        System.out.println("Result : "+addTask.getResult());
    }



}
