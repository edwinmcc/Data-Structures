package edu.learn.java.ds.general;

/**
 * Created by edwin on 20/09/16.
 */
public class RemoveDuplicateChars {

    /*
    public String removeDuplicateChars(String stringWithDuplicate) {
        int leftPtr=0;
        int rightPtr=leftPtr+1;
        char[] charArray = stringWithDuplicate.toCharArray();
        int charLength=charArray.length;
        if(stringWithDuplicate.length()==1)
        {
            return stringWithDuplicate;
        }
        for(int i=0;i<charArray.length && rightPtr<charLength;i++) {

            // If left char == right char just move the right pointer
            if(charArray[leftPtr]==charArray[rightPtr]) {
                rightPtr++;
            }
            else {
                // If left char != right char then move left pointer
                // A
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
    */

    public String removeDuplicateChars(String str)
    {
        if(str==null)
        {
            return str;
        }
        int length = str.length();
        if(length<2)
        {
            return str;
        }
        char[] inputString = str.toCharArray();
        int rightPtr = 1;
        for(int i=1;i<length;i++)
        {
            int leftPtr;
            for(leftPtr=0;leftPtr<rightPtr;leftPtr++)
            {
                if(inputString[i] == inputString[leftPtr])
                {
                    break;
                }
            }
            if(leftPtr == rightPtr)
            {
                inputString[rightPtr]=inputString[i];
                rightPtr++;
            }
        }
        if(rightPtr>length)
        {
            rightPtr=length;
        }
        return new String(inputString,0,rightPtr);
    }


    public static void main(String ...args) {
        RemoveDuplicateChars rdc=new RemoveDuplicateChars();
        //String  abc="abcdefghijkl";
        //String abc="aaabcdddeeeefghijkkll";
        String abc="1112234445566";
        System.out.println("Input String : "+abc);
        if(abc==null) {
            System.out.println("Unique String : "+abc);
            return;
        }
        System.out.println("Unique String : "+rdc.removeDuplicateChars(abc));
    }

}
