package edu.learn.java.ds.permutations;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by egnanasigamony on 23/02/2017.
 */
public class Combinations {

    static int count=0;
    public static void main(String[] args)
    {
        /*
        char[] values = {'a', 'b', 'c', 'd', 'e'};
        int n = values.length;
        int r = 3;
        int output[] = new int[r];

        for(int numIterations=0; numIterations<Math.pow(n,r); numIterations++)
        {
            print(values, r, output);
            int index = 0;
            while(index < r)
            {
                if(output[index] < n-1)
                {
                    System.out.println("\n   1 : index : "+index+" n-1 : "+(n-1)+" output[index] "+output[index]);
                    output[index]++;
                    break;
                }
                else
                {
                    System.out.println("\n   2   index : "+index);
                    output[index]=0;
                }
                index++;
            }
        }*/


        int[] number = { 2,3,4};
        Combinations cs=new Combinations();
        List<String> words=cs.letterCombinations("24310");
        for(String word : words) {
            System.out.println("Words : "+word);
        }
    }

    private static void print(char[] values, int r, int[] output)
    {
        System.out.print(String.format("\n%2d", ++count) + ") ");
        int i=0;
        while(i<r)
        {
            System.out.print(output[i++]);
        }
    }


    /*

    public List<String> letterCombinations(String digits) {
        String[] letters = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        LinkedList<String> list = new LinkedList<>();
        list.add("");
        for (int i = 0; i < digits.length(); i++) {
            int num = digits.charAt(i) - '2';
            int size = list.size();
            for (int k = 0; k < size; k++) {
                String tmp = list.pop();
                for (int j = 0; j < letters[num].length(); j++)
                    list.add(tmp + letters[num].charAt(j));
            }
        }
        List<String> rec = new LinkedList<>();
        rec.addAll(list);
        return rec;
    } */

    long globalIndex=0;

    private static final String[] KEYS = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        List<String> ret = new LinkedList<String>();
        combination("", digits, 0, ret);
        return ret;
    }

    private void printString(String message) {
        for(int i=0;i<globalIndex;i++) {
            System.out.print("--");
        }
        System.out.println("-->"+message);
    }

    private void combination(String prefix, String digits, int offset, List<String> ret) {
        printString("Prefix : "+prefix+" offset : "+offset);
        if (offset >= digits.length()) {
            printString("Returning . . . adding prefix : "+prefix);
            globalIndex--;
            if(prefix.indexOf("01")>=0 || prefix.indexOf("10")>0 || prefix.indexOf("00")>=0 || prefix.indexOf("11")>=0) {
                // Avoid adding phone numbers which has two continuous 0 & 1
                return;
            }
            ret.add(prefix);
            return;
        }
        String letters = KEYS[(digits.charAt(offset) - '0')];
        for (int i = 0; i < letters.length(); i++) {
            printString("Prefix : "+prefix+" i : "+i+" letters : "+letters+" letters.charAt(i) : "+letters.charAt(i)+" offset : "+offset);
            globalIndex++;
            combination(prefix + letters.charAt(i), digits, offset + 1, ret);
        }
    }
}