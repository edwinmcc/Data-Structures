package edu.learn.java.ds.permutations;

import java.util.Scanner;

/**
 * Created by egnanasigamony on 24/02/2017.
 */
public class SamSubStrings  {

    long sum=0;
    String number="";
    public static void main(String ...args) {
        SamSubStrings ss=new SamSubStrings();
        Scanner scanner=new Scanner(System.in);
        ss.number=scanner.next();
        ss.findSubString("",ss.number);


    }

    public void findSubString(String prefix, String suffix) {
        int n=suffix.length();
        System.out.println(prefix);
        for(int i=0;i<n;i++) {
            //findSubString(prefix+number.charAt(i),suffix.substring(0,i)+suffix.substring(i+1,suffix.length()), suffix.length());
            findSubString(prefix+number.charAt(n-(i+1)),suffix.substring(i+1,n));
        }
    }

}
