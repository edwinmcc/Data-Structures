package edu.learn.java.ds.general;

import java.util.Scanner;

/**
 * Created by edwin on 3/02/17.
 */

class Student {
    int mark;
    int numberOfCandies;
}

public class Candies  {

    private Student[] students;

    public static void main(String ...args) {
        Candies candies=new Candies();
        candies.calculateCandyCount();
    }

    public void calculateCandyCount() {
        Scanner scanner=new Scanner(System.in);
        //System.out.println("Enter the number of students : ");
        int marks[] = new int[] {
                2,
                4,
                2,
                6,
                1,
                7,
                8,
                9,
                2,
                1};

        int studentCount=marks.length;
        students = new Student[studentCount];

        students[0].mark=scanner.nextInt();
        students[0].numberOfCandies=1;

        for(int i=1;i<marks.length;i++) {
            System.out.println(String.format("Mark for student[%d]",i));
            students[i]=new Student();
            //students[i].mark=scanner.nextInt();
            students[i].mark=marks[i];
            students[i].numberOfCandies=1; // Everyone gets alleast 1
        }

        for(int i=1;i<studentCount;i++) {
            if(students[i].mark>students[i-1].mark) {
                students[i].numberOfCandies = students[i-1].numberOfCandies +1;
            }
        }

        for(int i=studentCount-1;i>0;i--) {
            if(students[i-1].mark>students[i].mark) {
                students[i-1].numberOfCandies = Math.max(students[i-1].numberOfCandies,students[i].numberOfCandies+1);
            }
        }

        int totalCandies=0;
        for(int i=0;i<studentCount;i++) {
            System.out.println(String.format("%d - M(%d) - C(%d)",i,students[i].mark,students[i].numberOfCandies));
            totalCandies = totalCandies + students[i].numberOfCandies;
        }
        System.out.println(totalCandies);
    }

}
