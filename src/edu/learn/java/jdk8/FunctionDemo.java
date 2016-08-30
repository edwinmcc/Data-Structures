package edu.learn.java.jdk8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        List<String> list= Arrays.asList("a", "ab", "abc", "abcd", "abcde");

        Map<String,Integer> resultMap=createMap(list,(s)->s.length());
        for(Map.Entry<String,Integer> entry : resultMap.entrySet()) {
            System.out.println("Key : "+entry.getKey()+" Value : "+entry.getValue());
        }
    }
}
