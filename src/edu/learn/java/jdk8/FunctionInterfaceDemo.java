package edu.learn.java.jdk8;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by edwin on 24/09/16.
 */


public class FunctionInterfaceDemo {

    public static void main(String ...args) {

        // Quadratic Equation : x^2 + 5x + 10;

        //Function<Integer,Integer> xSquare = ( x ) -> x * x ;
        //Function<Integer,Integer> xConstMul = (x) -> x * 5 ;
        Function<Integer,Integer> xAddConst = (x) -> x + 10;

        BiFunction<Integer,Integer,Integer> xSquare = (a,x) -> a * x;

        BiFunction<Integer,Integer,Integer> quadraticEquation = xSquare.andThen(xAddConst);

        System.out.println("Value of qe : "+quadraticEquation.apply(10,10));

        // ax^2 + bx + c;

        //-b (+/-) sq(b^2-4ac)/2a

        solveQuadraticEquation(1, -7, 12);
    }

    public static void solveQuadraticEquation(int a, int b, int c) {
        System.out.printf("Quadratic Equation : %dx^2 + %dx + %d",a,b,c);

        double b24ac= Math.sqrt(b*b-4*a*c);
        double x1 = (-b + b24ac) / 2 * a;
        double x2 = (-b - b24ac) / 2 * a;

        System.out.printf(" X1 : %f  X2 : %f ",x1,x2);

    }

}
