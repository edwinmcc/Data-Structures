package edu.learn.java.ds.permutations;

import java.util.ArrayList;

/**
 * Created by edwin on 7/09/16.
 */
public class NumberPermutations  {

    private static void printList(ArrayList<Integer> list) {
        for(Integer n : list) {
            System.out.print(n+"  ");
        }
        System.out.println();
    }

    private static void permuteNumbers(ArrayList<Integer> prefix, ArrayList<Integer> suffix, int listLength) {
        int suffixLength = suffix.size();
        if (suffixLength == listLength) {
            printList(prefix);
        }
        else {
            for (int i = 0; i < suffixLength; i++) {
                ArrayList<Integer> prefixList=new ArrayList(prefix);
                prefixList.add(suffix.get(i));
                ArrayList<Integer> suffixList=new ArrayList<Integer>(suffix.subList(0,i));
                suffixList.addAll(suffix.subList(i+1,suffixLength));
                permuteNumbers(prefixList, suffixList,listLength);
            }
        }
    }

    public static void main(String ...args) {
        ArrayList<Integer> prefix=new ArrayList<>();
        ArrayList<Integer> suffix=new ArrayList<>();
        for(int i=0;i<5;i+=1) {
            suffix.add(i*5);
        }
        permuteNumbers(prefix,suffix,prefix.size());
    }
}
