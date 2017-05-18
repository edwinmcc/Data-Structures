package edu.learn.java.jdk8;

import java.util.function.*;
import java.util.function.Function;

/**
 * Created by edwin on 30/08/16.
 */


public class IntMaxFunction implements BiFunction<Integer,Integer, Integer> {

    class SquareFunction implements  Function<Integer, Integer>  {

        @Override
        public Integer apply(Integer integer) {
            return integer.intValue() * integer.intValue();
        }
    }


    @Override
    public Integer apply(Integer integer1, Integer integer2) {
        return (integer1.intValue()>integer2.intValue()) ? integer1 : integer2;
    }

    public void compute() {
        IntMaxFunction intMaxFunction=new IntMaxFunction();
        System.out.println(" Value : "+intMaxFunction.andThen(new SquareFunction()).apply(10,25));
    }


    public static void main(String ...args) {

        IntMaxFunction i1=new IntMaxFunction();
        i1.compute();
    }



}
