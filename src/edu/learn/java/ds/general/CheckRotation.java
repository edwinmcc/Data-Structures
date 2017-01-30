package edu.learn.java.ds.general;

/**
 * Created by edwin on 21/09/16.
 */
public class CheckRotation {

    private boolean isSubString(String s1, String s2) {
        return s2.contains(s1);
    }

    public boolean isRotation(String s1, String s2) {
        if(s1==null || s2==null) {
            return false;
        }
        if(s1.length()!=s2.length()) {
            return false;
        }
        String bigString=s2+s2;
        return isSubString(s1,bigString);
    }


    public static void main(String ...args) {
        CheckRotation cr=new CheckRotation();
        String s1="apple";
        String s2="ppale";
        String s3="pplea";

        System.out.println(" Is Rotation : "+cr.isRotation(s1,s2));
        System.out.println(" Is Rotation : "+cr.isRotation(s1,s3));
    }

}
