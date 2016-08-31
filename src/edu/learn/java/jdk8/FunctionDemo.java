package edu.learn.java.jdk8;

import java.util.*;

/**
 * Created by edwin on 30/08/16.
 */


@FunctionalInterface
interface Function<T,V> {
    V apply(T t);
}

public class FunctionDemo {

    public static <T,V> Map<T,V> createMap(List<T> list, Function<T,V> func) {
        Map<T,V> resultMap=new HashMap<T,V>();
        for(T t : list) {
            V v=func.apply(t);
            resultMap.put(t,v);
        }
        return resultMap;
    }

    public static void main(String ...args) {

        List<String> list= Arrays.asList("a", "b a", "c b a", "d c b a", "e d c b a");

        // Different Methods of sorting the same list.

        // Lamda Expression is the Comparator & Type is inferred
        // Explicit type
        //list.sort((String s1,String s2)->s1.compareToIgnoreCase(s2));
        // Type is inferred
        //list.sort((s1,s2)->s1.compareToIgnoreCase(s2));

        //list.sort(Comparator.comparing(String::length).reversed());
        list.sort(Comparator.comparing((String s) -> s.length()).reversed().thenComparing(String::hashCode));

        for(String s : list) {
            System.out.println("String is : "+s);
        }

        Map<String,Integer> resultMap=createMap(list,(s)->s.length());
        for(Map.Entry<String,Integer> entry : resultMap.entrySet()) {
            System.out.println("Key : "+entry.getKey()+" Value : "+entry.getValue());
        }
    }
}
