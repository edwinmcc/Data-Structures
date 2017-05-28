package edu.learn.java.concepts.pkg1;

/**
 * Created by egnanasigamony on 29/05/2017.
 */
public class Child extends Base {

    int callSuperIntAdd(int a,int b) {
        return super.packageAccessIntMethodReturnInt(a,b);
    }
}
