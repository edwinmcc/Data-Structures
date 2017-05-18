package edu.learn.java.jdk8;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * Created by egnanasigamony on 10/05/2017.
 *
 * Exercise 2
 :  Remove the words that have odd length s from the list. HINT: Use one of the new methods from JDK 8.
 */
public class OracleExercise2 {

    public static void main(String ...args) {
        List<String> names=null;

        String str="The key part of this homework is to use the new features of JDK 8 in the form of Lambda expressions and changes to existing APIs." +
                   "Although parts of this you could easily do with loops that is not the goal.  You should be able to complete all the exercises " +
                           "without resorting to a for or while loop.  When you develop your Lambda expressions have a look at them and see if they" +
                           " can be replaced with an equivalent method reference.";


        names = new ArrayList(Arrays.asList(str.split("\\s+")));

        /* Method 1
        names = names.stream().filter( (s)->(s.length()%2==0)).collect(toList());
        */
        /* Method 2:
        names=names.stream().filter( (s)-> (s.length()%2==0)).collect(ArrayList::new, ArrayList::add, (left, right) -> left.addAll(right));
        */

       // names.removeIf((s) -> (s.length()&1)==1);

        // Replace all entries in the list with upper case string
        //names.replaceAll(String::toUpperCase);

        System.out.println("Names : "+names.size());

        HashMap<String,Integer> map=new HashMap<>();
        map.put("a",1);
        map.put("b",9);
        map.put("c",8);
        map.put("d",7);
        map.put("e",6);
        map.put("f",5);
        map.put("g",4);
        map.put("h",4);
        map.put("i",3);
        map.put("j",2);

        StringBuilder sb=new StringBuilder();

        map.forEach( (k,v) -> sb.append(String.format("%s%d",k,v)));

        List<Integer> list=Arrays.asList(1,2,3,4,5,6,7,7,8);

        new Thread(() -> list.forEach( (n) -> System.out.println(n))).start();

        System.out.println("Result : "+sb.toString());

        // Exercise 1 - problems Sheet 2

        //List<String> lNames=names.stream().map(s -> s.toLowerCase()).collect(toList());

        // Exercise 2 - Problem Sheet 2
        List<String> lNames=names.stream().filter( s -> s.length()%2==1).map(String::toLowerCase).collect(toList());

        System.out.println("Lower case names "+lNames);

        //StringBuilder sb=new StringBuilder();
        System.out.println("2,3,4 string "+names.stream().limit(4).skip(1).collect(joining("-",":",":")));

        printLineCountInFile1();
        printLineCountInFile2();
    }

    private static void printLineCountInFile1() {
        try (BufferedReader reader= Files.newBufferedReader(Paths.get("e:\\TestCases\\datatools-testcases.txt"))) {
            //System.out.println("Number of words including duplicates : "+reader.lines().flatMap((line) -> Stream.of(line.split("\\s+"))).collect(toList()).size());
            //System.out.println("Number of without duplicates : "+reader.lines().flatMap((line) -> Stream.of(line.split("\\s+"))).distinct().collect(toList()).size());
        }
        catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private static void printLineCountInFile2() {
        try (BufferedReader reader= Files.newBufferedReader(Paths.get("e:\\TestCases\\datatools-testcases.txt"))) {
            System.out.println("******************");
            reader.lines().flatMap((line) -> Stream.of(line.split("[- .:,\"\'\\s+]+"))).map( (s) -> s.toLowerCase()).distinct().peek((s) -> System.out.println("Peek : "+s)).sorted((a,b) -> { System.out.println("a : "+a+" b : "+b); return b.length()-a.length();}).forEach(System.out::println);

            BiConsumer biConsumer;
            BiPredicate biPredicate;
            Consumer consumer;
            BiFunction biFunction;
        }
        catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
