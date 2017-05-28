package edu.learn.java.concepts.pkg1;

/**
 * Created by egnanasigamony on 29/05/2017.
 */
public class Base {

    int packageAccessIntMethodReturnInt(int a,int b) {
        System.out.println("packageAccessIntMethodReturnInt invoked");
       return a+b;
    }

    Integer packageAccessIntegerMethodReturnInteger(Integer a,Integer b) {
        System.out.println("packageAccessIntegerMethodReturnInteger invoked");
        return a+b;
    }



}
