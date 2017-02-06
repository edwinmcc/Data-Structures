package edu.learn.java.ds.general;

import java.util.Scanner;

/**
 * Created by egnanasigamony on 6/02/2017.
 */

/*

Implement a method to perform basic string compression using the counts
of repeated characters. For example, the string aabcccccaaa would become
a2blc5a3. If the "compressed" string would not become smaller than the original
string, your method should return the original string.
 */

public class StringCompress {

    private String compressString(String src) {
        char c='-';
        int repeatCount=0;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<src.length();i++) {
            if(c=='-') {
                c=src.charAt(0);
                repeatCount=1;
                continue;
            }
            if(src.charAt(i)==c) {
                repeatCount++;
            }
            else {
                sb.append(c);
                sb.append(repeatCount);
                c=src.charAt(i);
                repeatCount=1;
            }
        }
        sb.append(c);
        sb.append(repeatCount);
        if(sb.toString().length()<src.length()) {
            return sb.toString();
        }
        return src;
    }

    public static void main(String ...args) {
        StringCompress sc=new StringCompress();
        Scanner scanner=new Scanner(System.in);
        String str=scanner.next();
        System.out.println(String.format("Original String :%s: Compressed String :%s:",str,sc.compressString(str)));
    }

}
