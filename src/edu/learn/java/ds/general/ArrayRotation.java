package edu.learn.java.ds.general;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by egnanasigamony on 11/10/2016.
 */
public class ArrayRotation {

    int[] data=null;

    public ArrayRotation(int[] data) {
        this.data=data;
    }

    /**
     * This method rotates the array by n positions clockwise
     * @param n - is the number of positions we move clockwise.
     */
    private void rotate(int n) {

        if(n>data.length) {
            n = n % data.length;
        }
        reverse(data,0,data.length-1);
        reverse(data,0,n-1);
        reverse(data,n,data.length-1);
    }

    private void reverse(int[] array, int start, int end) {
        int s=start;
        int e=end;
        while(s<e) {
            int temp=array[s];
            array[s]=array[e];
            array[e]=temp;
            s++;
            e--;
        }
    }

    private void rotateArrayByOnePosition()
    {
        int lastPosition=data.length-1;
        int temp = data[lastPosition];
        for(int i=lastPosition;i>0;i--)
        {
            data[i] = data[i-1];
        }
        data[0] = temp;
    }

    private void rotateArrayByNPositions(int n)
    {
        for(int i=0;i<n;i++)
        {
            rotateArrayByOnePosition();
        }
    }

    private void printArray() {
        System.out.println(Arrays.toString(data));
    }

    public static void main(String ...args) {
        Scanner sc=new Scanner(System.in);
        int[] data= { 1,2,3,4,5,6,7 };
        ArrayRotation ar=new ArrayRotation(data);
        System.out.println("Before Rotation : ");
        ar.printArray();
        //ar.rotate(2);

        //ar.rotateArrayByOnePosition();
        ar.rotateArrayByNPositions(2);
        System.out.println("After Rotation : ");
        ar.printArray();
    }
}
