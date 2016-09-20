package edu.learn.java.ds.general;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.concurrent.Exchanger;

/**
 * Created by egnanasigamony on 20/09/2016.
 */



public class StringReverse {

    InputStreamReader isr=null;

    public StringReverse() {
        isr=new InputStreamReader(System.in);
    }


    public void onlyPrintAsReverse() {
        try {
            char c = (char) isr.read();
            if(c==10) {
                System.out.print("The reverse String is : ");
                return;
            }
            onlyPrintAsReverse();
            System.out.print(c);
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public void reverseAndPrint(String input) {
        if(input==null) {
            return;
        }
        else if(input.length()==0 || input.length()==1) {
            return;
        }
        char[] reverseChars=new char[input.length()];
        int i=0;
        for(;i<(input.length()/2);i++) {
            char temp=input.charAt(i);
            reverseChars[i]=input.charAt(input.length()-i-1);
            reverseChars[input.length()-i-1]=temp;
        }
        if((i*2)+1==input.length()) {
            reverseChars[i]=input.charAt(i);
        }
        System.out.println("The reverse String is : "+new String(reverseChars));
    }

    public static void main(String ...args) {
        StringReverse sr=new StringReverse();
        Scanner sc=new Scanner(System.in);
        System.out.print("\nPlease enter a string : ");
        //sr.onlyPrintAsReverse();
        sr.reverseAndPrint(sc.nextLine());
    }
}
