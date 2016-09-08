package edu.learn.java.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by egnanasigamony on 5/09/2016.
 */
public class StreamDemo {

    public static void main(String ...args) {

        List<String> words = Arrays.asList("a", "as", "aptitude", "answer", "c", "cat", "candle");

        // First way
        words.stream().filter(s -> s.startsWith("c")).map(s -> s.toUpperCase()).sorted().forEach( s -> System.out.println(s));

        // Second way
        words.stream().filter(s -> s.startsWith("c")).map(String::toUpperCase).sorted().forEach(System.out::println);

        System.out.println("Number of elements : "+IntStream.range(0,100).filter(i -> (i%5==0)).count());

    }

}
