package edu.learn.java.ds.general;

import java.util.*;

/**
 * Created by egnanasigamony on 4/10/2016.
 */

/*
    Given  sticks of lengths , use  of the sticks to construct a non-degenerate triangle with the maximum possible perimeter.
    Then print the lengths of its sides as  space-separated integers in non-decreasing order.

      If there are several valid triangles having the maximum perimeter:

        Choose the one with the longest maximum side (i.e., the largest value for the longest side of any valid triangle having the maximum perimeter).
        If more than one such triangle meets the first criterion, choose the one with the longest minimum side (i.e., the largest value for the shortest side of any valid triangle having the maximum perimeter).
        If more than one such triangle meets the second criterion, print any one of the qualifying triangles.
        If no non-degenerate triangle exists, print -1.

        Input Format

        The first line contains single integer, , denoting the number of sticks.
        The second line contains  space-separated integers, , describing the respective stick lengths.

        Constraints

        Output Format

        Print  non-decreasing space-separated integers, , , and  (where ) describing the respective lengths of a triangle meeting the criteria in the above Problem Statement.

        If no non-degenerate triangle can be constructed, print -1.

        Sample Input 0

        5
        1 1 1 3 3
        Sample Output 0

        1 3 3
        Sample Input 1

        3
        1 2 3
        Sample Output 1

        -1
        Explanation

        Sample Case 0:
        There are  possible unique triangles:

        The second triangle has the largest perimeter, so we print its side lengths on a new line in non-decreasing order.

        Sample Case 1:
        The triangle  is degenerate and thus can't be constructed, so we print -1 on a new line.
    */

class Triangle {

    private int s1, s2, s3;

    public Triangle(int s1, int s2, int s3) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
    }

    public int getMaxSide() {
        if (s1 > s2) {
            if(s1>s3) {
                return s1;
            }
        } else if (s2 > s3) {
            return s2;
        }
        return s3;
    }

    public int getMinSide() {
        if (s1 < s2) {
            if(s1<s3) {
                return s1;
            }
        } else if (s2 < s3) {
            return s2;
        }
        return s3;
    }

    public int getPerimeter() {
        return s1+s2+s3;
    }

    public String toString() {
        return String.format("%d-%d-%d",s1,s2,s3);
    }
}



public class MaximumPerimeterTriangle {

    private List<Triangle> triangleList=new ArrayList<Triangle>();
    private List<Triangle> maxPerimeterList=null;
    private List<Triangle> longMaxSideList=null;
    private List<Triangle> longMinSideList=null;

    public List<Triangle> getTriangleList() {
        return triangleList;
    }


    private void processMaxPerimeterTriangle(Triangle triangle) {
        if(maxPerimeterList==null) {
            maxPerimeterList=new ArrayList<>();
            maxPerimeterList.add(triangle);
        }
        else {
            Triangle triangle1=maxPerimeterList.get(0);
            if(triangle.getPerimeter()>triangle1.getPerimeter()) {
                maxPerimeterList.clear();
                maxPerimeterList.add(triangle);
            }
            else if(triangle.getPerimeter()==triangle1.getPerimeter()) {
                maxPerimeterList.add(triangle);
            }
        }
    }

    private void processLongestMaximumSide(Triangle triangle) {
        if(longMaxSideList==null) {
            longMaxSideList = new ArrayList<>();
            longMaxSideList.add(triangle);
        }
        else {
            Triangle triangle1=longMaxSideList.get(0);
            if(triangle.getMaxSide()>triangle1.getMaxSide()) {
                longMaxSideList.clear();
                longMaxSideList.add(triangle);
            }
            else if(triangle.getMaxSide()==triangle1.getMaxSide()) {
                longMaxSideList.add(triangle);
            }
        }
    }

    private void processLongestMinimumSide(Triangle triangle) {
        if(longMinSideList==null) {
            longMinSideList = new ArrayList<>();
            longMinSideList.add(triangle);
        }
        else {
            Triangle triangle1=longMinSideList.get(0);
            if(triangle.getMinSide()<triangle1.getMinSide()) {
                longMinSideList.clear();
                longMinSideList.add(triangle);
            }
            else if(triangle.getMinSide()==triangle1.getMinSide()) {
                longMinSideList.add(triangle);
            }
        }
    }

    private void makeTriangle(ArrayList<Integer> prefix, ArrayList<Integer> suffix) {
        int n=suffix.size();
        if(prefix.size()==3) {
            Triangle triangle=new Triangle(prefix.get(0),prefix.get(1),prefix.get(2));
            triangleList.add(triangle);
            processMaxPerimeterTriangle(triangle);
            processLongestMaximumSide(triangle);
            processLongestMinimumSide(triangle);
        }
        else {
            for(int i=0;i<n;i++) {
                ArrayList<Integer> prefixList=new ArrayList<Integer>(prefix);
                prefixList.add(suffix.get(i));
                ArrayList<Integer> suffixList=new ArrayList<Integer>(suffix.subList(0,i));
                suffixList.addAll(suffix.subList(i+1,n));
                makeTriangle(prefixList,suffixList);
            }
        }
    }

    public static void main(String ...args) {

        MaximumPerimeterTriangle mpt=new MaximumPerimeterTriangle();
        Scanner scanner=new Scanner(System.in);
        System.out.printf("Enter the number of points : ");
        int numberOfPoints=scanner.nextInt();
        ArrayList<Integer> intList=new ArrayList<Integer>();
        for(int i=0;i<numberOfPoints;i++) {
            intList.add(scanner.nextInt());
        }

        mpt.makeTriangle(new ArrayList<Integer>(),intList);

        List<Triangle> triangleList = mpt.getTriangleList();

        for(int i=0;i<triangleList.size();i++) {
            System.out.println("Triangle : "+triangleList.get(i));
        }

        for(int i=0;i<mpt.maxPerimeterList.size();i++) {
            System.out.println("Triangle Max Perimeter: "+mpt.maxPerimeterList.get(i));
        }

        Iterator iterator=mpt.longMaxSideList.iterator();
        for(int i=0;i<mpt.longMaxSideList.size();i++) {
            System.out.println("Triangle Max : "+iterator.next());
        }

        Collections.sort(mpt.longMaxSideList,Comparator.comparing(Triangle::getPerimeter).thenComparing(Triangle::getMaxSide).reversed());

        /*Collections.sort(mpt.longMaxSideList,Comparator.comparing(Triangle::getPerimeter).thenComparing(Triangle::getMaxSide).reversed()); */

        for(int i=0;i<mpt.longMaxSideList.size();i++) {
            System.out.println("Sorted :: Triangle Max : "+mpt.longMaxSideList.get(i));
        }

        Collections.sort(mpt.longMinSideList,Comparator.comparing(Triangle::getPerimeter).thenComparing(Triangle::getMinSide).reversed());

        Iterator iterator1=mpt.longMinSideList.iterator();
        for(int i=0;i<mpt.longMinSideList.size();i++) {
            System.out.println("Triangle Min : "+iterator1.next());
        }

        /*Triangle t1=new Triangle(scanner.nextInt(),scanner.nextInt(),scanner.nextInt());
        Triangle t2=new Triangle(scanner.nextInt(),scanner.nextInt(),scanner.nextInt());
        Triangle t3=new Triangle(scanner.nextInt(),scanner.nextInt(),scanner.nextInt());

        System.out.println("Max side t1 : "+t1.getMaxSide());
        System.out.println("Max side t2 : "+t2.getMaxSide());
        System.out.println("Max side t3 : "+t3.getMaxSide());
        */
    }
}
