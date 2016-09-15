package edu.learn.java.ds.matrix;

import edu.learn.java.ds.common.Matrix;

import java.util.Scanner;

/**
 * Created by edwin on 13/09/16.
 */


public class MatrixAddition {

    private Matrix m1;
    private Matrix m2;
    private Matrix result;

    public Matrix getM1() {
        return m1;
    }

    public void setM1(Matrix m1) {
        this.m1 = m1;
    }

    public Matrix getM2() {
        return m2;
    }

    public void setM2(Matrix m2) {
        this.m2 = m2;
    }

    public void add() {
        if(m1==null || m2==null) {
            System.out.println("One of the matrices is null.  Please check");
            return;
        }
        if( (m1.getRow()!=m2.getRow()) || m1.getCol()!=m2.getCol()) {
            System.out.println("Both matrices should have same row and col values.  Please check");
            return;
        }
        result = new Matrix(m1.getRow(),m2.getCol());
        for(int i=0;i<m1.getRow();i++) {
            for(int j=0;j<m2.getCol();j++) {
                result.setCellData(i,j,m1.getCellData(i,j)+m2.getCellData(i,j));
            }
        }
        result.printMatrix();
    }



    public static void main(String ...args) {
        MatrixAddition ma=new MatrixAddition();
        Scanner sc=new Scanner(System.in);
        int row=0,col=0;
        System.out.printf("Enter the number of rows : ");
        row=sc.nextInt();
        System.out.printf("\nEnter the number of cols : ");
        col=sc.nextInt();

        Matrix m1 = new Matrix(row,col);
        m1.getDataFromConsole();

        System.out.printf("Enter the number of rows : ");
        row=sc.nextInt();
        System.out.printf("\nEnter the number of cols : ");
        col=sc.nextInt();

        Matrix m2 = new Matrix(row,col);
        m2.getDataFromConsole();

        ma.setM1(m1);
        ma.setM2(m2);

        ma.add();


        //m1.printMatrix();
        //m2.printMatrix();



    }

}
