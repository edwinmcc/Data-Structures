package edu.learn.java.ds.permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edwin on 7/09/16.
 */
public class Permutations<T> {

    private void printList(List<T> list) {
        for (T n : list) {
            System.out.print(n+"  ");
        }
        System.out.println();
    }

    private void permute(ArrayList<T> prefix, ArrayList<T> suffix, int r) {
        int n = suffix.size();
        if (n == r) {
            printList(prefix);
        }
        else {
            for (int i = 0; i < n; i++) {
                ArrayList<T> prefixList=new ArrayList<T>(prefix);
                prefixList.add(suffix.get(i));
                ArrayList<T> suffixList=new ArrayList<T>(suffix.subList(0,i));
                suffixList.addAll(suffix.subList(i+1,n));
                permute(prefixList, suffixList,r);
            }
        }
    }

    public static void main(String ...args) {
        ArrayList<Integer> prefix=new ArrayList<>();
        ArrayList<Integer> suffix=new ArrayList<>();
        for(int i=0;i<5;i++) {
            suffix.add(i);
        }

        Permutations<Integer> permutations=new Permutations<>();
        permutations.permute(prefix,suffix,prefix.size());
    }

}
