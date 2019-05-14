package edu.learn.java.ds.matrix;

import edu.learn.java.ds.common.Matrix;

import java.util.Scanner;

/**
 * Created by egnanasigamony on 22/09/2016.
 */
public class MatrixRotation {

    private Matrix matrix=null;

    public void setMatrix(Matrix m) {
        this.matrix=m;
    }

    private void swapElements(int i1,int j1, int i2,int j2) {
        int temp=matrix.getCellData(i1,j1);
        matrix.setCellData(i1,j1,matrix.getCellData(i2,j2));
        matrix.setCellData(i2,j2,temp);
    }

    public void rotateMatrix() {
        int numberOfLayers=matrix.getCol()/2;
        int size = matrix.getCol();
        for(int layer=0;layer<numberOfLayers;layer++) {
            int first=layer;
            int last=size-layer-1;
            for(int i=first;i<last;i++) {
                swapElements(layer,i,i,last);
                swapElements(layer,i, last, last - i + layer);
                swapElements(layer,i, last - i + layer, layer);
            }
        }
    }

    public static void main(String ...args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter the number for (N x N) matrix ");
        int row=sc.nextInt();
        int col=row;

        Matrix m1=new Matrix(row,col);
        int value=0;
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                m1.setCellData(i,j,value);
                value++;
            }
        }
        MatrixRotation mr = new MatrixRotation();
        m1.printMatrix();
        mr.setMatrix(m1);
        mr.rotateMatrix();
        mr.rotateMatrix();
        mr.rotateMatrix();
        System.out.println("\n\n");
        m1.printMatrix();


    }
}
