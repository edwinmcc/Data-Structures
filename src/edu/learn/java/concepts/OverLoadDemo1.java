package edu.learn.java.concepts;

/**
 * Created by egnanasigamony on 24/03/2017.
 */


class Base {
    public void method1() {
        System.out.println("Printing from Base");
    }

    /*
    public void intArg(int i) {
        System.out.println("Printing from Base intArg int : "+i);
    }*/

    public void intArg(Integer i) {
        System.out.println("Printing from Base intArg Integer : "+i);
    }

}

class Child extends Base {

    public void method1() {
        System.out.println("Printing from Child");
    }

    public void intArg(int i) {
        System.out.println("Printing from Child intArg int : "+i);
    }

    public void intArg(Integer i) {
        System.out.println("Printing from Child intArg Integer : "+i);
    }
}

public class OverLoadDemo1 {

    public static void main(String ...args) {
        Base b1=new Base();
        b1.method1();
        Base b2=new Child();
        b2.method1();

        b1.intArg(5);
        b1.intArg(new Integer(10));

        b2.intArg(5);
        b2.intArg(new Integer(10));


    }

}
