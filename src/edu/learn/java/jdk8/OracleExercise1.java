package edu.learn.java.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import static java.util.stream.Collectors.toList;

/**
 * Created by egnanasigamony on 9/05/2017.
 */


/*

Exercise 1  : Create a string that consists of the first letter of each word in the list of Strings provided

HINT:         Use a StringBuilder to construct the result.

*/

public class OracleExercise1 {

    class StringToChar implements Function<String,Character> {
        @Override
        public Character apply(String s) {
            return s.charAt(0);
        }
    }

    class CharCollect implements Consumer<Character> {

        StringBuilder sb=new StringBuilder();

        @Override
        public void accept(Character character) {
            sb.append(character);
        }

        public String toString() {
            return sb.toString();
        }
    }

    private StringToChar getStringToChar() {
        return new StringToChar();
    }

    public CharCollect getCharCollect() {
        return new CharCollect();
    }

    public static void main(String ...args) {
        List<String> strList=new ArrayList<String>();

        OracleExercise1 exercise1=new OracleExercise1();

        OracleExercise1.StringToChar stringToChar = exercise1.getStringToChar();

        strList.add("zen");
        strList.add("yen");
        strList.add("xen");
        strList.add("wen");
        strList.add("ven");
        strList.add("uen");
        strList.add("ten");
        strList.add("sen");
        strList.add("ren");
        strList.add("qen");
        strList.add("pen");

        StringBuilder sb=new StringBuilder();

        strList=strList.stream().map(s -> s.toUpperCase()).collect(toList());

        String str=strList.stream().map(stringToChar::apply).collect(StringBuilder::new,StringBuilder::append,StringBuilder::append).toString();
        System.out.println("Final String : "+str);

    }

}
