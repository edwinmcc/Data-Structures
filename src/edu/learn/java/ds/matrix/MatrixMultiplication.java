package edu.learn.java.ds.matrix;

import edu.learn.java.ds.common.Matrix;

import java.util.Scanner;

/**
 * Created by edwin on 16/09/16.
 */
public class MatrixMultiplication {

    private Matrix m1;
    private Matrix m2;
    private Matrix m3;

    public MatrixMultiplication(Matrix m1, Matrix m2) {
        this.m1=m1;
        this.m2=m2;
    }

    public void multiply() {

        int mr1=m1.getRow();
        int mc1=m1.getCol();

        int mr2=m2.getRow();
        int mc2=m2.getCol();

        if(mc1!=mr2) {
            System.out.println("The number of columns in the first Matrix should be equal to number of rows in 2nd matrix");
            return;
        }

        m3 = new Matrix(mr1,mc2);
        int sum=0;
        for(int i=0;i<mr1;i++) {
            for(int j=0;j<mc2;j++) {
                sum=0;
                for(int k=0;k<mc1;k++) {
                    sum=sum+m1.getCellData(i,k)*m2.getCellData(k,j);
                }
                m3.setCellData(i,j,sum);
            }
        }
    }

    public void printResult() {
        m3.printMatrix();
    }

    public static void main(String ...args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter row col of matrix 1");
        int r1=0,c1=0;
        r1=sc.nextInt();
        c1=sc.nextInt();

        Matrix m1=new Matrix(r1,c1);
        m1.getDataFromConsole();

        System.out.println("Enter row col of matrix 2");
        r1=sc.nextInt();
        c1=sc.nextInt();

        Matrix m2=new Matrix(r1,c1);
        m2.getDataFromConsole();

        MatrixMultiplication mm=new MatrixMultiplication(m1,m2);
        mm.multiply();
        mm.printResult();
    }
}
