package edu.learn.java.ds.general;

/**
 * Created by edwin on 20/09/16.
 */
public class RemoveDuplicateChars {

    char[] charArray = null;

    public void setChars(char[] charArray) {
        this.charArray = charArray;
    }

    public String removeDuplicateChars() {
        int leftPtr=0;
        int rightPtr=leftPtr+1;
        int charLength=charArray.length;
        //System.out.println("String : "+new String(charArray)+ " length : "+charLength);
        for(int i=0;i<charArray.length && rightPtr<charLength;i++) {
            if(charArray[leftPtr]==charArray[rightPtr]) {
                rightPtr++;
                //System.out.println(" 1 String "+new String(charArray)+" leftPtr : "+leftPtr+" rightPtr : "+rightPtr);
            }
            else {
                //System.out.println(" 2 String "+new String(charArray)+" leftPtr : "+leftPtr+" rightPtr : "+rightPtr);
                leftPtr++;
                charArray[leftPtr]=charArray[rightPtr];
                rightPtr++;
                //System.out.println(" 3 String "+new String(charArray)+" leftPtr : "+leftPtr+" rightPtr : "+rightPtr);
            }
        }
        if(leftPtr >0 && charArray[leftPtr]==charArray[rightPtr-1]) {
            leftPtr++;
        }
        return new String(charArray,0,leftPtr);
    }

    public static void main(String ...args) {
        RemoveDuplicateChars rdc=new RemoveDuplicateChars();
        //String  abc="abcdefghijkl";
        //String abc="aaabcdddeeeefghijkkll";
        String abc="113334433222222455433234223";
        System.out.println("Input String : "+abc);
        if(abc==null) {
            System.out.println("Unique String : "+abc);
            return;
        }
        rdc.setChars(abc.toCharArray());
        System.out.println("Unique String : "+rdc.removeDuplicateChars());
    }

}
