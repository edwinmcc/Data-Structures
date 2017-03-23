package edu.learn.java.ds.permutations;

/**
 * Created by egnanasigamony on 23/02/2017.
 */
public class CombinationsK {

    public static void choose(char[] a, int k) {
        enumerate(a, a.length, k);
    }

    private static void enumerate(char[] a, int n, int k) {
        if (k == 0) {
            for (int i = n; i < a.length; i++)
                System.out.print(a[i]);
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            swap(a, i, n-1);
            enumerate(a, n-1, k-1);
            swap(a, i, n-1);
        }
    }

    // helper function that swaps a[i] and a[j]
    public static void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // sample client
    public static void main(String[] args) {
        //int n = Integer.parseInt(args[0]);
        //int k = Integer.parseInt(args[1]);
        int n=5;
        int k=5;
        String elements = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        char[] a = new char[n];
        for (int i = 0; i < n; i++)
            a[i] = elements.charAt(i);
        choose(a, k);
    }

}
