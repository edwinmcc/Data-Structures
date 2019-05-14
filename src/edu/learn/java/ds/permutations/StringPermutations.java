package edu.learn.java.ds.permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edwin on 7/09/16.
 */
public class StringPermutations {

    public static void permuteString(List<String> allOptions,String prefix, String suffix, int wordLength)
    {
        int suffixLength = suffix.length();
        if (wordLength == prefix.length())
        {
            //System.out.println(prefix);
            if(!allOptions.contains(prefix))
            {
                allOptions.add(prefix);
            }
        }
        else
        {
            for (int i = 0; i < suffixLength; i++)
            {
                permuteString(allOptions, prefix + suffix.charAt(i), suffix.substring(0, i) + suffix.substring(i+1, suffixLength), wordLength);
            }
        }
    }

    public static void allPermutations(String prefix,String suffix,int length) {
        if(prefix.length()==length) {
            System.out.println(prefix);
        }
        else if(prefix.length()==length-1) {
            System.out.println(prefix + "::"+suffix );
        }
        int n=suffix.length();
        for (int i = 0; i < n; i++) {
            allPermutations(prefix + suffix.charAt(i), suffix.substring(0, i) + suffix.substring(i + 1, n),length);
        }
    }

    public static void allRepetitivePermutations(String prefix,String suffix,int length) {
        if(prefix.length()==length || prefix.length()==length-1)
            System.out.println(prefix + "::"+suffix );

        for (int i = 0; i < length; i++) {
            allRepetitivePermutations(prefix + suffix.charAt(i), suffix.substring(0, i) + suffix.substring(i+1, length),length);
        }
    }

    public static boolean isAnagram(String word, String checkWord)
    {
        List<String> allOptions = new ArrayList<>();
        permuteString(allOptions,"",word,word.length());
        if(allOptions.contains(checkWord))
        {
            return true;
        }
        return false;
    }

    public static void main(String ...args) {
        String str="abcd";
        //StringPermutations.permuteString("",str,str.length()-4);
        //StringPermutations.permuteString("",str,2);
        //StringPermutations.allPermutations("",str,str.length());
        //StringPermutations.allRepetitivePermutations("",str,str.length()-1);

        //List<String> allOptions = new ArrayList<>();
        //StringPermutations.permuteString(allOptions,"",str,str.length());
        /*
        System.out.println("The length of array : "+allOptions.size());
        for(String option : allOptions)
        {
            System.out.println(option);
        }
        */
        System.out.println("abcd is an anagram of bcda : "+StringPermutations.isAnagram("abcd", "adcb"));
    }
}
