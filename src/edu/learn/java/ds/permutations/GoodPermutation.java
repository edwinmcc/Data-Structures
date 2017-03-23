package edu.learn.java.ds.permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by egnanasigamony on 24/02/2017.
 */
public class GoodPermutation {

    String charClass[] = { "abcd", "ABCD", "12","!@#$%"};
    long   globalIndex=0;

    public void print(String message) {
        for(int i=0;i<globalIndex;i++) {
            System.out.print("--");
        }
        System.out.println("-->"+message);
    }

    public void combine(String prefix, String letters, int offset, List<String> set) {
        print("Prefix : "+prefix+" letters : "+letters +" offset : "+offset);
        if(prefix.length()==letters.length()) {
            set.add(prefix);
            return;
        }
        String subset=charClass[offset];
        for(int i=0;i<subset.length();i++) {
            combine(prefix+subset.charAt(i),letters,offset+1,set);
        }
    }

    public static void main(String ...args) {
        List<String> finalSet=new ArrayList<String>();
        GoodPermutation gp=new GoodPermutation();
        gp.combine("","abcd",0,finalSet);
        for(String entry: finalSet) {
            System.out.println(entry);
        }
    }

}
