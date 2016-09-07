package edu.learn.java.ds.permutations;

/**
 * Created by edwin on 7/09/16.
 */
public class StringPermutations {

    private static void permuteString(String prefix, String suffix, int r) {
        int n = suffix.length();
        if (n == r) {
            System.out.println(prefix);
        }
        else {
            for (int i = 0; i < n; i++) {
                permuteString(prefix + suffix.charAt(i), suffix.substring(0, i) + suffix.substring(i+1, n),r);
            }
        }
    }

    public static void allPermutations(String prefix,String suffix) {
        System.out.println(prefix);
        int n=suffix.length();
        for (int i = 0; i < n; i++) {
            allPermutations(prefix + suffix.charAt(i), suffix.substring(0, i) + suffix.substring(i+1, n));
        }
    }

    public static void main(String ...args) {
        String str="abcd";

        //StringPermutations.permuteString("",str,str.length()-4);
        StringPermutations.allPermutations("",str);
    }
}
