package edu.learn.java.ds.permutations;

/**
 * Created by edwin on 7/09/16.
 */
public class StringPermutations {

    private static void permuteString(String prefix, String suffix, int r) {
        int n = suffix.length();
        if (r == prefix.length()) {
            System.out.println(prefix);
        }
        else {
            for (int i = 0; i < n; i++) {
                permuteString(prefix + suffix.charAt(i), suffix.substring(0, i) + suffix.substring(i+1, n),r);
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


    public static void main(String ...args) {
        String str="abcd";
        //StringPermutations.permuteString("",str,str.length()-4);
        //StringPermutations.permuteString("",str,2);
        StringPermutations.allPermutations("",str,str.length());
        //StringPermutations.allRepetitivePermutations("",str,str.length()-1);
    }
}
