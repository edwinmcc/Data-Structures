package edu.learn.java.ds.matrix;

import edu.learn.java.ds.common.Matrix;

import java.util.Scanner;

/**
 * Created by egnanasigamony on 20/09/2016.
 */
public class MatrixTranspose {

    Matrix m1;
    Matrix m1Trp;

    public void setM1(Matrix m1) {
        this.m1=m1;
    }

    public Matrix getM1() {
        return m1;
    }

    public Matrix getTransposedMatrix() {
        return m1Trp;
    }

    public void transpose() {
        if (m1 == null) {
            System.out.println("Input Matri is null");
            return;
        }
        if(m1.getRow()==0 || m1.getCol()==0) {
            System.out.println("Input Matrix either has a row or column as zero");
            return;
        }
        if(m1.getRow()==1 && m1.getCol()==1) {
            return;
        }
        m1Trp = new Matrix(m1.getCol(),m1.getRow());
        for(int i=0;i<m1.getRow();i++) {
            for(int j=0;j<m1.getCol();j++) {
                m1Trp.setCellData(j,i,m1.getCellData(i,j));
            }
        }
    }

    public static void main(String ...args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Please enter the number of rows: ");
        int row=sc.nextInt();
        System.out.print("Please enter the number of cols: ");
        int col=sc.nextInt();

        Matrix m1=new Matrix(row,col);
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                System.out.printf("\n Please enter the value for arr[%d][%d] :",i,j);
                int temp=sc.nextInt();
                m1.setCellData(i,j,temp);
            }
        }

        MatrixTranspose mt=new MatrixTranspose();
        mt.setM1(m1);
        mt.transpose();
        mt.getTransposedMatrix().printMatrix();
    }
}
